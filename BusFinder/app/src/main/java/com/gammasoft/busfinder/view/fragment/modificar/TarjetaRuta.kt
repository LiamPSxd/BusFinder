package com.gammasoft.busfinder.view.fragment.modificar

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaModificarRutaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.fragment.Mapa
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaRuta(private val localDB: Crud,
                  private val ruta: Ruta): BaseBlurPopup(){
    private var _binding: TarjetaModificarRutaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaRuta(localDB, ruta).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaModificarRutaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val mapa = childFragmentManager.findFragmentById(R.id.mapaRutaMod) as Mapa
        mapa.parada = false
        mapa.ruta = true

        val coordenadas = ArrayList<Coordenada>()
        localDB.getCoordenadasIDByRutaID(ruta.getId()).observe(viewLifecycleOwner){
            for(cR in it) localDB.getCoordenadaById(cR.getCoordenadaID()).observe(viewLifecycleOwner){ coor ->
                coordenadas.add(coor)
                CoroutineScope(Dispatchers.IO).launch{
                    localDB.deleteCoordenada(coor)
                }
            }
        }

        var inicio = "${coordenadas[0].getLongitud()},${coordenadas[0].getLatitud()}"
        for(i in 1 until coordenadas.size){
            val fin = "${coordenadas[i].getLongitud()},${coordenadas[i].getLatitud()}"
            mapa.crearRutas(inicio, fin)
            inicio = fin
        }

        binding.txtRuta.text = Editable.Factory().newEditable(ruta.getNombre())

        binding.btnAtras.setOnClickListener{
            mapa.deshacer()
        }

        binding.btnLimpiar.setOnClickListener{
            mapa.map.clear()

            inicio = "${coordenadas[0].getLongitud()},${coordenadas[0].getLatitud()}"
            for(i in 1 until coordenadas.size) {
                val fin = "${coordenadas[i].getLongitud()},${coordenadas[i].getLatitud()}"
                mapa.crearRutas(inicio, fin)
                inicio = fin
            }
        }

        binding.btnCancelar.setOnClickListener{
            dismiss()
        }

        binding.btnModificar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val ru = binding.txtRuta.text.toString()
                mapa.agregar()

                if(ru.isNotEmpty() && mapa.coordenadas.isNotEmpty()){
                    CoroutineScope(Dispatchers.IO).launch{
                        ruta.setNombre(ru)
                        localDB.updateRuta(ruta)
                        CloudDataBase.addRuta(ruta)

                        for(i in 0 until mapa.coordenadas.size){
                            val id = if(i <= coordenadas.size-1) coordenadas[i].getId()
                            else 0

                            val coor = Coordenada(id, mapa.coordenadas[i].getLongitud(), mapa.coordenadas[i].getLatitud(), coordenadas[0].getAdministrador())
                            localDB.addCoordenadas(coor)
                            CloudDataBase.addCoordenada(coor)

                            val rC = RutaCoordenada(ruta.getId(), coor.getId())
                            localDB.addRutaCoordenadas(rC)
                            CloudDataBase.addRutaCoordenada(rC)
                        }
                    }

                    Toast.makeText(requireContext(), "¡Ruta modificada con éxito!", Toast.LENGTH_SHORT).show()
                    dismiss()
                }else if(ru.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar el nombre de la Ruta").show(parentFragmentManager, "Advertencia")
                else if(mapa.coordenadas.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe dibujar una Ruta").show(parentFragmentManager, "Advertencia")
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