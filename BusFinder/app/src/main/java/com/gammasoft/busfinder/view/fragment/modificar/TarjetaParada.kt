package com.gammasoft.busfinder.view.fragment.modificar

import android.os.Bundle
import android.text.Editable
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
import com.gammasoft.busfinder.databinding.TarjetaModificarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Parada
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.fragment.Mapa
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import com.google.android.gms.maps.model.LatLng
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaParada(private val localDB: Crud,
                    private val bin: FragmentAdministradorBinding,
                    private val parada: Parada): BaseBlurPopup(){
    private var _binding: TarjetaModificarParadaBinding? = null
    private val binding get() = _binding!!

    private var ruta = ""

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaParada(localDB, bin, parada).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaModificarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val mapa = childFragmentManager.findFragmentById(R.id.mapaParadaMod) as Mapa
        mapa.ruta = false
        mapa.parada = false

        mapa.crearParada(LatLng(parada.getLatitud(), parada.getLongitud()))

        binding.txtParada.text = Editable.Factory().newEditable(parada.getNombre())

        val rutas = ArrayList<String>()
        localDB.getRutas().observe(viewLifecycleOwner){
            for(ruta in it) rutas.add(ruta.getNombre())
        }

        var contador = 0
        localDB.getRutaIDByParadaID(parada.getId()).observe(viewLifecycleOwner){
            localDB.getRutaById(it.getRutaID()).observe(viewLifecycleOwner){ r ->
                for(i in 0 until rutas.size)
                    if(rutas[i] == r.getNombre()){
                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.deleteRutaParada(it)
                        }
                        contador = i
                    }
            }
        }

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            rutas
        ).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            with(binding.spSeleccion){
                adapter = it
                setSelection(contador, true)
                onItemSelectedListener = SpinnerEvento()
                prompt = "Seleccione una Ruta"
                gravity = Gravity.START
                setBackgroundResource(R.color.white)
            }
        }

        binding.btnAtras.setOnClickListener{
            mapa.deshacer()
        }

        binding.btnLimpiar.setOnClickListener{
            mapa.map.clear()
            mapa.crearParada(LatLng(parada.getLatitud(), parada.getLongitud()))
        }

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnModificar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val p = binding.txtParada.text.toString()
                mapa.agregar()

                if(p.isNotEmpty() && ruta.isNotEmpty() && mapa.paradas.isNotEmpty()){
                    if(mapa.paradas.size == 1){
                        CoroutineScope(Dispatchers.IO).launch{
                            parada.setNombre(p)
                            parada.setLatitud(mapa.paradas[0].getLatitud())
                            parada.setLongitud(mapa.paradas[0].getLongitud())
                            localDB.updateParada(parada)
                            CloudDataBase.addParada(parada)
                        }

                        localDB.getRutaByNombre(ruta).observe(viewLifecycleOwner){
                            CoroutineScope(Dispatchers.IO).launch{
                                val rP = RutaParada(it.getId(), parada.getId())
                                localDB.addRutaParadas(rP)
                                CloudDataBase.addRutaParada(rP)
                            }
                        }

                        Toast.makeText(requireContext(), "¡Parada modificada con éxito!", Toast.LENGTH_SHORT).show()
                        bin.btnAgregar.visibility = View.VISIBLE
                        dismiss()
                    }else MensajeAlerta("ERROR", "Hay más de una Parada").show(parentFragmentManager, "Error")
                }else if(p.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar el nombre de la Parada").show(parentFragmentManager, "Advertencia")
                else if(ruta.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una Ruta").show(parentFragmentManager, "Advertencia")
                else if(mapa.paradas.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una Parada").show(parentFragmentManager, "Advertencia")
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