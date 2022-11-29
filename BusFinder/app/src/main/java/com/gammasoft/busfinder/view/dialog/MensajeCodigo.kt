package com.gammasoft.busfinder.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.gammasoft.busfinder.databinding.TarjetaCodigoBinding
import com.gammasoft.busfinder.view.util.vibrate

class MensajeCodigo(private val tipo: String,
                    private val clickListener: (Long) -> Unit): DialogFragment(){
    private var _binding: TarjetaCodigoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog{
        _binding = TarjetaCodigoBinding.inflate(layoutInflater)

        context?.vibrate(60L)

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnAceptar.setOnClickListener{
            val codigo = binding.txtCodigo.text.toString()

            if(codigo.isNotEmpty()){
                /*var codigos = ArrayList<Codigo>()

                when(tipo){
                    "Administrador" -> codigos = CloudDataBase.getCodigosAdministrador()
                    "Chofer" -> codigos = CloudDataBase.getCodigosChofer()
                }*/

                //for(i in codigos){
                    val y: Long = 123456
                    if(/*!i.getEstado() &&*/ codigo.toLong() == y /*i.getValor()*/){
                        /*when(tipo){
                            "Administrador" -> CloudDataBase.addCodigoAdministrador(Codigo(i.getId(), i.getValor(), true))
                            "Chofer" -> CloudDataBase.addCodigoChofer(Codigo(i.getId(), i.getValor(), true))
                        }*/

                        clickListener.invoke(codigo.toLong())
                        dismiss()
                    }/*else if(i.getEstado()){
                        val x = "El código ya está en uso"
                        binding.etqTitulo.text = x
                    }else{
                        val x = "El código es incorrecto"
                        binding.etqTitulo.text = x
                    }
                }*/
            }else MensajeAlerta("ERROR", "Falta ingresar el código").show(parentFragmentManager, "Codigo")
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}