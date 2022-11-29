package com.gammasoft.busfinder.view.fragment.borrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaBorrarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Parada
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaParada(private val localDB: Crud,
                    private val bin: FragmentAdministradorBinding,
                    private val parada: Parada): BaseBlurPopup(){
    private var _binding: TarjetaBorrarParadaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaBorrarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.txtParada.text = parada.getNombre()

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnBorrar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                localDB.getParadaById(parada.getId()).observe(viewLifecycleOwner){
                    if(it.getLatitud() == parada.getLatitud()){
                        localDB.getRutaIDByParadaID(parada.getId()).observe(viewLifecycleOwner){ ruP ->
                            CoroutineScope(Dispatchers.IO).launch{
                                localDB.deleteRutaParada(ruP)
                                CloudDataBase.delete("RutaParada", "${ruP.getRutaID()}")
                            }
                        }

                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.deleteParada(parada)
                            CloudDataBase.delete("Parada", "${parada.getId()}")
                        }

                        Toast.makeText(requireContext(), "¡Parada borrada con éxito!", Toast.LENGTH_SHORT).show()
                        bin.btnAgregar.visibility = View.VISIBLE
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