package com.gammasoft.busfinder.view.fragment.borrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaBorrarChoferBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaChofer(private val localDB: Crud,
                    private val chofer: Chofer): BaseBlurPopup(){
    private var _binding: TarjetaBorrarChoferBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = this.withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaBorrarChoferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.txtRFC.text = chofer.getRfc()
        binding.txtNombre.text = chofer.getNombre()

        binding.btnCancelar.setOnClickListener{
            dismiss()
        }

        binding.btnBorrar.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                localDB.getChoferByRFC(chofer.getRfc()).observe(viewLifecycleOwner){
                    if(it.getNombre() == chofer.getNombre()){
                        localDB.deleteChofer(chofer)
                        chofer.setAdministrador("")
                        CloudDataBase.addChofer(chofer)

                        Toast.makeText(requireContext(), "¡Chofer borrado con éxito!", Toast.LENGTH_SHORT).show()
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