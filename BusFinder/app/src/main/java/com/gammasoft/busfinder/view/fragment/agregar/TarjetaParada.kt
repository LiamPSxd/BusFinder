package com.gammasoft.busfinder.view.fragment.agregar

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaAgregarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada
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

class TarjetaParada(private val bin: FragmentAdministradorBinding): BaseBlurPopup(){
    private var _binding: TarjetaAgregarParadaBinding? = null
    private val binding get() = _binding!!

    private var ruta = ""

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaParada(bin).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaAgregarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val localDB = LocalDataBase.getDB(requireContext()).crud()

        val mapa = childFragmentManager.findFragmentById(R.id.mapaParada) as Mapa
        mapa.ruta = false
        mapa.parada = true

        val rutas = ArrayList<String>()
        localDB.getRutas().observe(this){
            for(ruta in it) rutas.add(ruta.getNombre())
        }

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
            }
        }

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
                mapa.agregar()

                if(ruta.isNotEmpty() && mapa.paradas.isNotEmpty()){
                    localDB.getRutaByNombre(ruta).observe(this@TarjetaParada){
                        for(parada in mapa.paradas){
                            parentFragmentManager.setFragmentResultListener("Administrador", this@TarjetaParada){ _, bundle ->
                                parada.setAdministrador(bundle.getString("administrador").toString())
                            }

                            val rutaParada = RutaParada(it.getId(), parada.getId())

                            CoroutineScope(Dispatchers.IO).launch{
                                localDB.addParadas(parada)
                                localDB.addRutaParadas(rutaParada)
                                CloudDataBase.addParada(parada)
                                CloudDataBase.addRutaParada(rutaParada)
                            }
                        }

                        Toast.makeText(requireContext(), "¡Parada(s) agregada(s) con éxito!", Toast.LENGTH_SHORT).show()
                        dismiss()
                        bin.btnAgregar.visibility = View.VISIBLE
                    }
                }else if(ruta.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una Ruta").show(parentFragmentManager, "Advertencia")
                else if(mapa.paradas.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una o más Paradas").show(parentFragmentManager, "Advertencia")
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
            ruta = parent?.getItemAtPosition(position).toString()
        }

        override fun onNothingSelected(parent: AdapterView<*>?){}
    }
}