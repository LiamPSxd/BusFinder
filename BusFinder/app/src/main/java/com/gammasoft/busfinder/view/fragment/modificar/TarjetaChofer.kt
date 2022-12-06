package com.gammasoft.busfinder.view.fragment.modificar

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaModificarChoferBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
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

class TarjetaChofer(private val localDB: Crud,
                    private val bin: FragmentAdministradorBinding,
                    private val chofer: Chofer): BaseBlurPopup(){
    private var _binding: TarjetaModificarChoferBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaChofer(localDB, bin, chofer).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaModificarChoferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.txtRFC.text = Editable.Factory().newEditable(chofer.getRfc())

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnModificar.setOnClickListener{
            val rfc = binding.txtRFC.text.toString()

            if(rfc.isNotEmpty() && rfc.length == 13){
                CloudDataBase.cloudDataBase.collection("Chofer").whereEqualTo("rfc", rfc).get().addOnSuccessListener{
                    for(ch in it) if(ch.exists()){
                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.deleteChofer(chofer)
                            chofer.setAdministrador("")
                            CloudDataBase.addChofer(chofer)
                        }

                        chofer.setUsuario(ch.get("usuario").toString())
                        chofer.setRfc(ch.get("rfc").toString())
                        chofer.setNombre(ch.get("nombre").toString())
                        chofer.setNumCelular(ch.get("numeroCelular").toString().toLong())
                        chofer.setLinea(ch.get("lineaTransporte").toString())
                        chofer.setCodigo(ch.get("codigo").toString().toLong())
                        chofer.setNoUsuarios(ch.get("numeroUsuarios").toString().toInt())
                        chofer.setCalificacion(ch.get("calificacion").toString().toDouble())
                        chofer.setAdministrador(ch.get("administrador").toString())

                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.addChoferes(chofer)
                        }

                        localDB.getChoferByRFC(chofer.getRfc()).observe(viewLifecycleOwner){
                            CoroutineScope(Dispatchers.IO).launch{
                                CloudDataBase.addChofer(it)
                            }
                        }

                        Toast.makeText(requireContext(), "¡Chofer modificado con éxito!", Toast.LENGTH_LONG).show()
                        bin.btnAgregar.visibility = View.VISIBLE
                        dismiss()
                    }else MensajeAlerta("ERROR", "No se encontró ningún chofer con ese dato").show(parentFragmentManager, "Error")
                }
            }else if(rfc.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar el RFC del Chofer").show(parentFragmentManager, "Advertencia")
            else if(rfc.length != 13) MensajeAlerta("ADVERTENCIA", "El RFC está incompleto").show(parentFragmentManager, "Advertencia")
        }
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