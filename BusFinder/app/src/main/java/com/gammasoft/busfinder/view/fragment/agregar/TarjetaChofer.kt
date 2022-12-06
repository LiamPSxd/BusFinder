package com.gammasoft.busfinder.view.fragment.agregar

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaAgregarChoferBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaChofer(private val bin: FragmentAdministradorBinding): BaseBlurPopup(), AdapterView.OnItemSelectedListener{
    private var _binding: TarjetaAgregarChoferBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences
    private lateinit var localDB: Crud

    private var chSpinner = ""

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaChofer(bin).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaAgregarChoferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        localDB = LocalDataBase.getDB(requireContext()).crud()

        val choferes = ArrayList<String>()
        localDB.getChoferes().observe(this){
            for(chofer in it) if(chofer.getNombre() != "") choferes.add(chofer.getNombre())
        }
        choferes.add("Seleccione un Chofer")

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            choferes
        ).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            with(binding.spSeleccion){
                adapter = it
                setSelection(0, false)
                onItemSelectedListener = this@TarjetaChofer
                gravity = Gravity.START
            }
        }

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnAgregar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val chRFC = binding.txtRFC.text.toString()

                if(chRFC.isEmpty() && (chSpinner.isEmpty() || chSpinner == "Seleccione un Chofer")) MensajeAlerta("ERROR", "Debe ingresar o seleccionar un Chofer").show(parentFragmentManager, "Advertencia")
                else{
                    if(chRFC.isNotEmpty()){
                        if(chRFC.length == 13){
                            activity?.runOnUiThread{
                                localDB.getChoferByRFC(chRFC).observe(viewLifecycleOwner){
                                    if(it != null) agregar(it)
                                    else MensajeAlerta("ERROR", "No se encontró ningún Chofer con ese dato").show(parentFragmentManager, "Error")
                                }
                            }
                        }else MensajeAlerta("ADVERTENCIA", "El RFC debe tener 13 caracteres").show(parentFragmentManager, "Advertencia")
                    }else if(chSpinner.isNotEmpty()){
                        activity?.runOnUiThread{
                            localDB.getChoferByNombre(chSpinner).observe(viewLifecycleOwner){
                                if(it != null) agregar(it)
                                else MensajeAlerta("ERROR", "No se encontró ningún Chofer con ese dato").show(parentFragmentManager, "Error")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun agregar(chofer: Chofer){
        if(chofer.getRfc().isNotEmpty()){
            prefs = requireActivity().getSharedPreferences(activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
            localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
                localDB.getAdministradorByUsuario(it.getAdminUsuario()).observe(viewLifecycleOwner){ a ->
                    if(chofer.getAdministrador() != a.getRfc()){
                        chofer.setAdministrador(a.getRfc())

                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.addChoferes(chofer)
                        }

                        localDB.getChoferByRFC(chofer.getRfc()).observe(viewLifecycleOwner){
                            CoroutineScope(Dispatchers.IO).launch{
                                CloudDataBase.addChofer(it)
                            }
                        }

                        Toast.makeText(requireContext(), "¡Chofer agregado con éxito!", Toast.LENGTH_LONG).show()
                        bin.btnAgregar.visibility = View.VISIBLE
                        dismiss()
                    }else if(chofer.getAdministrador() == a.getRfc()) MensajeAlerta("ERROR", "El Chofer ya está agregado").show(parentFragmentManager, "Error")
                }
            }
        }else MensajeAlerta("ERROR", "Chofer no encontrado").show(parentFragmentManager, "Error")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
        chSpinner = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?){}

    override fun onDestroy(){
        super.onDestroy()
        bin.btnAgregar.visibility = View.VISIBLE
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): View = binding.tarjeta

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout
}