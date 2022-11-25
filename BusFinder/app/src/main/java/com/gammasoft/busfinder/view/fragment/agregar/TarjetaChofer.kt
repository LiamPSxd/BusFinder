package com.gammasoft.busfinder.view.fragment.agregar

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaAgregarChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaChofer: BaseBlurPopup(){
    private var _binding: TarjetaAgregarChoferBinding? = null
    private val binding get() = _binding!!

    private val localDB = LocalDataBase.getDB(requireContext()).crud()
    private var chSpinner = ""

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaChofer().withEnterAnim(enterAnim).withExitAnim(exitAnim)

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

        val choferes = ArrayList<String>()
        localDB.getChoferes().observe(this){
            for(chofer in it) choferes.add(chofer.getNombre())
        }

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            choferes
        ).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            with(binding.spSeleccion){
                adapter = it
                setSelection(0, false)
                onItemSelectedListener = SpinnerEvento()
                prompt = "Seleccione un Chofer"
                gravity = Gravity.START
                setBackgroundResource(R.color.white)
            }
        }

        binding.btnCancelar.setOnClickListener{
            dismiss()
        }

        binding.btnAgregar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val chRFC = binding.txtRFC.text.toString()
                var chofer = Chofer()

                if(chRFC.isNotEmpty()){
                    localDB.getChoferByRFC(chRFC).observe(this@TarjetaChofer){
                        chofer = it
                    }
                }else if(chSpinner.isNotEmpty()){
                    localDB.getChoferByNombre(chSpinner).observe(this@TarjetaChofer){
                        chofer = it
                    }
                }

                localDB.addChoferes(chofer)
                CloudDataBase.addChofer(chofer)
            }
        }
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
            chSpinner = parent?.getItemAtPosition(position).toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?){}
    }
}