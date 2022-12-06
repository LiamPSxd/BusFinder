package com.gammasoft.busfinder.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.gammasoft.busfinder.databinding.TarjetaAlertaBinding
import com.gammasoft.busfinder.view.util.vibrate

class MensajeAlerta(private val titulo: String,
                    private val mensaje: String): DialogFragment(){
    private var _binding: TarjetaAlertaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog{
        _binding = TarjetaAlertaBinding.inflate(layoutInflater)

        context?.vibrate(100L)

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.etqTitulo.text = titulo
        binding.txtMensaje.text = mensaje

        binding.btnAceptar.setOnClickListener{ dismiss() }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}