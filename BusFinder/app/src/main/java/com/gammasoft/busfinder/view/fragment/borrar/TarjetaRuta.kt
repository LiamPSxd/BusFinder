package com.gammasoft.busfinder.view.fragment.borrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaBorrarRutaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaRuta(private val localDB: Crud,
                  private val ruta: Ruta): BaseBlurPopup(){
    private var _binding: TarjetaBorrarRutaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = this.withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaBorrarRutaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.txtRuta.text = ruta.getNombre()

        binding.btnCancelar.setOnClickListener{
            dismiss()
        }

        binding.btnBorrar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                localDB.getRutaById(ruta.getId()).observe(viewLifecycleOwner){
                    if(it.getNombre() == ruta.getNombre()){
                        localDB.getCoordenadasIDByRutaID(ruta.getId()).observe(viewLifecycleOwner){ coorRus ->
                            for(coorRu in coorRus){
                                CoroutineScope(Dispatchers.IO).launch{
                                    localDB.deleteRutaCoordenada(coorRu)
                                    CloudDataBase.delete("RutaCoordenada", "${coorRu.getRutaID()}")
                                }

                                localDB.getCoordenadaById(coorRu.getCoordenadaID()).observe(viewLifecycleOwner){ coor ->
                                    CoroutineScope(Dispatchers.IO).launch{
                                        localDB.deleteCoordenada(coor)
                                        CloudDataBase.delete("Coordenada", "${coor.getId()}")
                                    }
                                }
                            }
                        }

                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.deleteRuta(ruta)
                            CloudDataBase.delete("Ruta", "${ruta.getId()}")
                        }

                        Toast.makeText(requireContext(), "¡Ruta borrada con éxito!", Toast.LENGTH_SHORT).show()
                        dismiss()
                    }
                }
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