package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.TarjetaAgregarEvento
import com.gammasoft.busfinder.databinding.*
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.dialog.MensajeAlerta

class TarjetaAgregar(private val fragment: AgregarAdministrador,
                     private val titulo: String): BaseTarjeta(){
    private var _binding: TarjetaAgregarBinding? = null
    private val binding get() = _binding!!

    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
    private lateinit var evento: TarjetaAgregarEvento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = TarjetaAgregarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val c = binding.frameAgregarChofer
        val r = binding.frameAgregarRuta
        val p = binding.frameAgregarParada
        val t = binding.frameAgregarTarifa

        evento = TarjetaAgregarEvento(this, titulo, binding, localDB)

        visualizarFrame(c, r, p, t)
        asignarEvento(c, r, p, t, evento)
    }

    override fun getBackgroundBlurLayout(): ViewGroup = binding.blurLayout

    override fun getDragView(): View = binding.dragArea

    override fun getRootView(): ViewGroup = binding.tarjeta

    override fun dragHandleId(): Int = binding.dragHandleImage.id

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    private fun visualizarFrame(c: FrameAgregarChoferBinding, r: FrameAgregarRutaBinding, p: FrameAgregarParadaBinding, t: FrameAgregarTarifaBinding){
        when(titulo){
            "Chofer" -> {
                c.Chofer.visibility = View.VISIBLE
                r.Ruta.visibility = View.GONE
                p.Parada.visibility = View.GONE
                t.Tarifa.visibility = View.GONE
            }

            "Ruta" -> {
                c.Chofer.visibility = View.GONE
                r.Ruta.visibility = View.VISIBLE
                p.Parada.visibility = View.GONE
                t.Tarifa.visibility = View.GONE
            }

            "Parada" -> {
                c.Chofer.visibility = View.GONE
                r.Ruta.visibility = View.GONE
                p.Parada.visibility = View.VISIBLE
                t.Tarifa.visibility = View.GONE
            }

            "Tarifa" -> {
                c.Chofer.visibility = View.GONE
                r.Ruta.visibility = View.GONE
                p.Parada.visibility = View.GONE
                t.Tarifa.visibility = View.VISIBLE
            }

            else -> MensajeAlerta("Error", "Include no encontrado").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    private fun asignarEvento(c: FrameAgregarChoferBinding, r: FrameAgregarRutaBinding, p: FrameAgregarParadaBinding, t: FrameAgregarTarifaBinding, evento: TarjetaAgregarEvento){
        when(titulo){
            "Chofer" -> {
                localDB.getChoferes().observe(fragment.viewLifecycleOwner){
                    val choferes = arrayListOf<String>()
                    for(chofer in it) choferes.add(chofer.getNombre())

                    ArrayAdapter.createFromResource(
                        fragment.requireContext(),
                        choferes.toString().toInt(),
                        android.R.layout.simple_spinner_item
                    ).also{ adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        c.spSeleccion.adapter = adapter
                    }
                }

                c.spSeleccion.onItemSelectedListener = evento
                c.btnAceptar.setOnClickListener(evento)
                c.btnCancelar.setOnClickListener(evento)
            }

            "Ruta" -> {
                r.btnAceptar.setOnClickListener(evento)
                r.btnCancelar.setOnClickListener(evento)
            }

            "Parada" -> {
                localDB.getParadas().observe(fragment.viewLifecycleOwner){
                    val paradas = arrayListOf<String>()
                    for(parada in it) paradas.add(parada.getNombre())

                    ArrayAdapter.createFromResource(
                        fragment.requireContext(),
                        paradas.toString().toInt(),
                        android.R.layout.simple_spinner_item
                    ).also{ adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        p.spSeleccion.adapter = adapter
                    }
                }

                p.spSeleccion.onItemSelectedListener = evento
                p.btnAceptar.setOnClickListener(evento)
                p.btnCancelar.setOnClickListener(evento)
            }

            "Tarifa" -> {
                localDB.getTarifas().observe(fragment.viewLifecycleOwner){
                    val tarifas = arrayListOf("Público General", "Tercera Edad", "Estudiantes")
                    for(tarifa in it) tarifas.add(tarifa.getNombre())

                    ArrayAdapter.createFromResource(
                        fragment.requireContext(),
                        tarifas.toString().toInt(),
                        android.R.layout.simple_spinner_item
                    ).also{ adapter ->
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        t.spSeleccion.adapter = adapter
                    }
                }

                t.spSeleccion.onItemSelectedListener = evento
                t.skPrecio.setOnSeekBarChangeListener(evento)
                t.btnAceptar.setOnClickListener(evento)
                t.btnCancelar.setOnClickListener(evento)
            }

            else -> MensajeAlerta("Error", "Include no encontrado").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }
}