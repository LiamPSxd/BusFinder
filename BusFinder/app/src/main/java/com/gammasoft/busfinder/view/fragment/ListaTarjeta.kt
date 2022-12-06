package com.gammasoft.busfinder.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.FragmentListaTarjetaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.view.adapter.TarjetaLista
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class ListaTarjeta(private val fragment: TarjetaBase,
                   private val bin: FragmentAdministradorBinding,
                   private val titulo: String,
                   private val localDB: Crud): BaseBlurPopup(){
    private var _binding: FragmentListaTarjetaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentListaTarjetaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val prefs = fragment.requireActivity().getSharedPreferences(fragment.activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
        localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
            localDB.getAdministradorByUsuario(it.getAdminUsuario()).observe(viewLifecycleOwner){ admin ->
                binding.cabecera.text = titulo

                val ides = ArrayList<List<String>>()
                when(titulo){
                    "CHOFERES" -> {
                        ides.clear()
                        localDB.getChoferesByAdministrador(admin.getRfc()).observe(viewLifecycleOwner){ choferes ->
                            for(chofer in choferes) if(chofer.getRfc().isNotEmpty()) ides.add(listOf(chofer.getRfc(), chofer.getNombre()))

                            reformatear(ides)
                            binding.recyclerView.adapter = TarjetaLista(fragment, bin, titulo, ides)
                        }
                    }

                    "RUTAS" -> {
                        ides.clear()
                        localDB.getRutasByAdministrador(admin.getRfc()).observe(viewLifecycleOwner){ rutas ->
                            for(ruta in rutas) if(ruta.getNombre().isNotEmpty()) ides.add(listOf(ruta.getId().toString(), ruta.getNombre()))

                            reformatear(ides)
                            binding.recyclerView.adapter = TarjetaLista(fragment, bin, titulo, ides)
                        }
                    }

                    "PARADAS" -> {
                        ides.clear()
                        localDB.getParadasByAdministrador(admin.getRfc()).observe(viewLifecycleOwner){ paradas ->
                            for(parada in paradas) if(parada.getNombre().isNotEmpty()) ides.add(listOf(parada.getId().toString(), parada.getNombre()))

                            reformatear(ides)
                            binding.recyclerView.adapter = TarjetaLista(fragment, bin, titulo, ides)
                        }
                    }

                    "TARIFAS" -> {
                        ides.clear()
                        localDB.getTarifasByAdministrador(admin.getRfc()).observe(viewLifecycleOwner){ tarifas ->
                            for(tarifa in tarifas) if(tarifa.getNombre().isNotEmpty()) ides.add(listOf(tarifa.getNombre(), tarifa.getNombre()))

                            reformatear(ides)
                            binding.recyclerView.adapter = TarjetaLista(fragment, bin, titulo, ides)
                        }
                    }
                }
            }
        }
    }

    private fun reformatear(ides: ArrayList<List<String>>){
        if(ides.isEmpty()) ides.add(listOf("Nada que mostrar", "Agregue un dato para mostrarlo"))
        else if(ides.size > 2)
            for(i in ides.indices){
                if(i < ides.size-1) if(ides[i][0] == "Nada que mostrar" || ides[i][0] == ides[i+1][0]) ides.removeAt(i+1)
            }
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): ViewGroup = binding.lista

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout
}