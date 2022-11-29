package com.gammasoft.busfinder.view.fragment.agregar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaAgregarRutaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
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

class TarjetaRuta(private val bin: FragmentAdministradorBinding): BaseBlurPopup(){
    private var _binding: TarjetaAgregarRutaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaRuta(bin).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaAgregarRutaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val localDB = LocalDataBase.getDB(requireContext()).crud()

        val mapa = childFragmentManager.findFragmentById(R.id.mapaRuta) as Mapa
        mapa.parada = false
        mapa.ruta = true

        binding.btnAtras.setOnClickListener{
            mapa.deshacer()
        }

        binding.btnLimpiar.setOnClickListener{
            mapa.limpiarMapa()
        }

        binding.btnCancelar.setOnClickListener{
            dismiss()
            bin.btnAgregar.visibility = View.VISIBLE
        }

        binding.btnAgregar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val ruta = binding.txtRuta.text.toString()
                mapa.agregar()

                if(ruta.isNotEmpty() && mapa.coordenadas.isNotEmpty()){
                    var admin = ""
                    parentFragmentManager.setFragmentResultListener("Administrador", this@TarjetaRuta){ _, bundle ->
                        admin = bundle.getString("administrador").toString()
                    }

                    val r = Ruta(ruta, admin)

                    for(coor in mapa.coordenadas) {
                        coor.setAdministrador(admin)
                        val rC = RutaCoordenada(r.getId(), coor.getId())

                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.addCoordenadas(coor)
                            localDB.addRutaCoordenadas(rC)
                            CloudDataBase.addCoordenada(coor)
                            CloudDataBase.addRutaCoordenada(rC)
                        }
                    }

                    CoroutineScope(Dispatchers.IO).launch{
                        localDB.addRutas(r)
                        CloudDataBase.addRuta(r)
                    }

                    Toast.makeText(requireContext(), "¡Ruta agregada con éxito!", Toast.LENGTH_SHORT).show()
                    dismiss()
                    bin.btnAgregar.visibility = View.VISIBLE
                }else if(ruta.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar la Ruta").show(parentFragmentManager, "Advertencia")
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