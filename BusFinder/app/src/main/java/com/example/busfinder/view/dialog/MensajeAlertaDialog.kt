package com.example.busfinder.view.dialog

import android.content.Context
import androidx.appcompat.app.AlertDialog

class MensajeAlertaDialog(private var contexto: Context, private var titulo: String, private var mensaje: String): AlertDialog.Builder(contexto){
    private lateinit var dialog: AlertDialog

    fun mostrarAlerta(){
        this.setTitle(titulo)
        this.setMessage(mensaje)
        this.setPositiveButton("Aceptar", null)

        dialog = this.create()
        dialog.show()
    }
}