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
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaAgregarTarifaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaTarifa(private val bin: FragmentAdministradorBinding): BaseBlurPopup(), AdapterView.OnItemSelectedListener{
    private var _binding: TarjetaAgregarTarifaBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences
    private lateinit var localDB: Crud

    private var tarifa = ""

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaTarifa(bin).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaAgregarTarifaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        localDB = LocalDataBase.getDB(requireContext()).crud()

        val tarifas = ArrayList<String>()
        localDB.getTarifas().observe(this){
            for(tarifa in it) if(tarifa.getNombre() != "") tarifas.add(tarifa.getNombre())
        }
        tarifas.add("Seleccione un Público")
        tarifas.add("Otro")

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            tarifas
        ).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            with(binding.spSeleccion){
                adapter = it
                setSelection(0, false)
                onItemSelectedListener = this@TarjetaTarifa
                gravity = Gravity.START
            }
        }

        binding.skPrecio.setOnSeekBarChangeListener(
            object: SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ){
                    binding.txtPrecio.text = progress.toString()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?){}

                override fun onStopTrackingTouch(seekBar: SeekBar?){
                    binding.txtPrecio.text = seekBar?.progress?.toString()
                }
            }
        )

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnAgregar.setOnClickListener{
            val precio = binding.txtPrecio.text.toString()
            val publico = if(tarifa == "Otro") binding.txtOtro.text.toString()
            else tarifa

            if((publico.isNotEmpty() && publico != "Seleccione un Público") && precio.isNotEmpty()){
                prefs = requireActivity().getSharedPreferences(activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
                localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
                    localDB.getAdministradorByUsuario(it.getAdminUsuario()).observe(viewLifecycleOwner){ a ->
                        val tarifa = Tarifa(publico, precio.toDouble(), a.getRfc())

                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.addTarifas(tarifa)
                        }

                        localDB.getTarifaByNombre(tarifa.getNombre()).observe(viewLifecycleOwner){
                            CoroutineScope(Dispatchers.IO).launch{
                                CloudDataBase.addTarifa(it)
                            }
                        }

                        Toast.makeText(requireContext(), "¡Tarifa agregada con éxito!", Toast.LENGTH_LONG).show()
                        bin.btnAgregar.visibility = View.VISIBLE
                        dismiss()
                    }
                }
            }else if(publico.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar un Público").show(parentFragmentManager, "Advertencia")
            else if(publico == "Seleccione un Público") MensajeAlerta("ERROR", "Seleccione otro Público").show(parentFragmentManager, "Error")
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
        tarifa = parent?.getItemAtPosition(position).toString()
        binding.txtOtro.isEnabled = tarifa == "Otro"
    }

    override fun onNothingSelected(parent: AdapterView<*>?){
        binding.txtOtro.isEnabled = parent?.selectedItem == "Otro"
    }

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