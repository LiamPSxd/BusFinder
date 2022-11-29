package com.gammasoft.busfinder.view.fragment.visualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaVisualizarRutaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.Mapa
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.vibrate
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class TarjetaRuta(private val fragment: TarjetaBase,
                  private val bin: FragmentAdministradorBinding,
                  private val titulo: String,
                  private val id: String): BaseBlurPopup(){
    private var _binding: TarjetaVisualizarRutaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaRuta(fragment, bin, titulo, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

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
        val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

        var ruta = Ruta()
        localDB.getRutas().observe(viewLifecycleOwner){
            for(ru in it) if(ru.getId() == id.toInt() && ru.getNombre() == titulo){
                binding.txtRuta.text = ru.getNombre()
                ruta = ru
                break
            }
        }

        val mapa = childFragmentManager.findFragmentById(R.id.mapa) as Mapa

        val coordenadas = ArrayList<Coordenada>()
        localDB.getCoordenadasIDByRutaID(ruta.getId()).observe(viewLifecycleOwner){
            for(cR in it) localDB.getCoordenadaById(cR.getCoordenadaID()).observe(viewLifecycleOwner){ coor ->
                coordenadas.add(coor)
            }
        }

        var inicio = "${coordenadas[0].getLongitud()},${coordenadas[0].getLatitud()}"
        for(i in 1 until coordenadas.size){
            val fin = "${coordenadas[i].getLongitud()},${coordenadas[i].getLatitud()}"
            mapa.crearRutas(inicio, fin)
            inicio = fin
        }

        bin.btnAgregar.visibility = View.GONE

        binding.btnBorrar.setOnClickListener{
            fragment.context?.vibrate(70L)
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaRuta(localDB, bin, ruta).mostrar())
        }

        binding.btnModificar.setOnClickListener{
            fragment.context?.vibrate(60L)
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaRuta(localDB, bin, ruta).mostrar())
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