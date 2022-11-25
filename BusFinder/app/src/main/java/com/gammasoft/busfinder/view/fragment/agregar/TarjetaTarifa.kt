package com.gammasoft.busfinder.view.fragment.agregar

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaAgregarTarifaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaTarifa: BaseBlurPopup(){
    private var _binding: TarjetaAgregarTarifaBinding? = null
    private val binding get() = _binding!!

    private val localDB = LocalDataBase.getDB(requireContext()).crud()
    private var tarifa = ""

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaTarifa().withEnterAnim(enterAnim).withExitAnim(exitAnim)

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

        val tarifas = ArrayList<String>()
        localDB.getTarifas().observe(this){
            for(tarifa in it) tarifas.add(tarifa.getNombre())
        }
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
                onItemSelectedListener = SpinnerEvento()
                prompt = "Seleccione un Público"
                gravity = Gravity.START
                setBackgroundResource(R.color.white)
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
            dismiss()
        }

        binding.btnAgregar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val publico = if(tarifa == "Otro") binding.txtOtro.text.toString()
                else tarifa

                val precio = binding.txtPrecio.text.toString().toDouble()

                val tarifa = Tarifa(publico, precio)
                localDB.addTarifas(tarifa)
                CloudDataBase.addTarifa(tarifa)
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
            tarifa = parent?.getItemAtPosition(position).toString()

            binding.txtOtro.isEnabled = tarifa == "Otro"
        }

        override fun onNothingSelected(parent: AdapterView<*>?){}
    }
}