package com.gammasoft.busfinder.view.fragment.modificar

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaModificarTarifaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
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

class TarjetaTarifa(private val localDB: Crud,
                    private val tarifa: Tarifa): BaseBlurPopup(){
    private var _binding: TarjetaModificarTarifaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaTarifa(localDB, tarifa).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaModificarTarifaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.txtTarifa.text = Editable.Factory().newEditable(tarifa.getNombre())
        binding.txtPrecio.text = tarifa.getPrecio().toString()
        binding.skPrecio.progress = tarifa.getPrecio().toString().toInt()

        val publicos = ArrayList<String>()
        localDB.getTarifas().observe(viewLifecycleOwner){
            for(publico in it) publicos.add(publico.getNombre())
        }

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            publicos
        ).also{ binding.txtTarifa.setAdapter(it) }

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

        binding.btnModificar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val publico = binding.txtTarifa.text.toString()
                val precio = binding.txtPrecio.text.toString()

                if(publico.isNotEmpty() && precio.isNotEmpty()){
                    CoroutineScope(Dispatchers.IO).launch{
                        tarifa.setNombre(publico)
                        tarifa.setPrecio(precio.toDouble())
                        localDB.updateTarifa(tarifa)
                        CloudDataBase.addTarifa(tarifa)
                    }

                    Toast.makeText(requireContext(), "¡Tarifa modificada con éxito!", Toast.LENGTH_SHORT).show()
                    dismiss()
                }else if(publico.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar el Público").show(parentFragmentManager, "Advertencia")
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
}