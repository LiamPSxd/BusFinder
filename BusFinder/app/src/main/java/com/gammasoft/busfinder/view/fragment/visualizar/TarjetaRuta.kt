package com.gammasoft.busfinder.view.fragment.visualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaVisualizarRutaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class TarjetaRuta(private val fragment: TarjetaBase,
                  private val id: String): BaseBlurPopup(){
    private var _binding: TarjetaVisualizarRutaBinding? = null
    private val binding get() = _binding!!

    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaRuta(fragment, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaVisualizarRutaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        var ruta = Ruta()

        localDB.getRutaByNombre(id).observe(viewLifecycleOwner){ ru ->
            binding.txtRuta.text = ru.getNombre()
            ruta = ru
        }

        binding.btnBorrar.setOnClickListener{
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaRuta(localDB, ruta).mostrar())
        }

        binding.btnModificar.setOnClickListener{
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaRuta(localDB, ruta).mostrar())
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