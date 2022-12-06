package com.gammasoft.busfinder.view.fragment.borrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaBorrarTarifaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaTarifa(private val localDB: Crud,
                    private val bin: FragmentAdministradorBinding,
                    private val tarifa: Tarifa): BaseBlurPopup(){
    private var _binding: TarjetaBorrarTarifaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaTarifa(localDB, bin, tarifa).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaBorrarTarifaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.txtTarifa.text = tarifa.getNombre()

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnBorrar.setOnClickListener{
            localDB.getTarifaByNombre(tarifa.getNombre()).observe(viewLifecycleOwner){
                if(it != null) if(it.getPrecio() == tarifa.getPrecio()){
                    CoroutineScope(Dispatchers.IO).launch{
                        localDB.deleteTarifa(tarifa)
                        CloudDataBase.delete("Tarifa", tarifa.getNombre())
                    }
                }

                Toast.makeText(requireContext(), "¡Tarifa borrada con éxito!", Toast.LENGTH_LONG).show()
                bin.btnAgregar.visibility = View.VISIBLE
                dismiss()
            }
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