package com.gammasoft.busfinder.view.fragment.modificar

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaModificarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Parada
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class TarjetaParada(private val localDB: Crud,
                    private val parada: Parada): BaseBlurPopup(){
    private var _binding: TarjetaModificarParadaBinding? = null
    private val binding get() = _binding!!

    private var ruta = ""

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaParada(localDB, parada).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaModificarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val rutas = ArrayList<String>()
        for(ruta in CloudDataBase.getRutas()) rutas.add(ruta.getNombre())

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            rutas
        ).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            with(binding.spSeleccion){
                adapter = it
                setSelection(0, false)
                onItemSelectedListener = SpinnerEvento()
                prompt = "Seleccione una Ruta"
                gravity = Gravity.START
                setBackgroundResource(R.color.white)
            }
        }

        binding.btnAtras.setOnClickListener{}

        binding.btnLimpiar.setOnClickListener{}

        binding.btnCancelar.setOnClickListener{
            dismiss()
        }

        binding.btnModificar.setOnClickListener{}
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): View = binding.tarjeta

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout

    inner class SpinnerEvento: AdapterView.OnItemSelectedListener{
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
            ruta = parent?.getItemAtPosition(position).toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?){}
    }
}