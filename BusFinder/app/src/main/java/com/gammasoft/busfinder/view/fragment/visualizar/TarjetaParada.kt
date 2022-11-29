package com.gammasoft.busfinder.view.fragment.visualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaVisualizarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Parada
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.Mapa
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.vibrate
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import com.google.android.gms.maps.model.LatLng
import io.alterac.blurkit.BlurLayout

class TarjetaParada(private val fragment: TarjetaBase,
                    private val titulo: String,
                    private val id: String): BaseBlurPopup(){
    private var _binding: TarjetaVisualizarParadaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaParada(fragment, titulo, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaVisualizarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

        var parada = Parada()
        localDB.getParadas().observe(viewLifecycleOwner){
            for(p in it) if(p.getId() == id.toInt() && p.getNombre() == titulo){
                binding.txtParada.text = p.getNombre()

                localDB.getRutaIDByParadaID(p.getId()).observe(viewLifecycleOwner){ r ->
                    localDB.getRutaById(r.getRutaID()).observe(viewLifecycleOwner){ ruta ->
                        binding.txtRuta.text = ruta.getNombre()
                    }
                }

                parada = p
                break
            }
        }

        val mapa = childFragmentManager.findFragmentById(R.id.mapa) as Mapa
        mapa.crearParada(LatLng(parada.getLatitud(), parada.getLongitud()))

        binding.btnBorrar.setOnClickListener{
            fragment.context?.vibrate(70L)
            dismiss()
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaParada(localDB, parada).mostrar())
        }

        binding.btnModificar.setOnClickListener{
            fragment.context?.vibrate(60L)
            dismiss()
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaParada(localDB, parada).mostrar())
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