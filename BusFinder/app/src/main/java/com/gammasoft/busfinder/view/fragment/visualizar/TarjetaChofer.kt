package com.gammasoft.busfinder.view.fragment.visualizar

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaVisualizarChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.vibrate
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class TarjetaChofer(private val fragment: TarjetaBase,
                    private val bin: FragmentAdministradorBinding,
                    private val titulo: String,
                    private val id: String): BaseBlurPopup(){
    private var _binding: TarjetaVisualizarChoferBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaChofer(fragment, bin, titulo, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaVisualizarChoferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

        bin.btnAgregar.visibility = View.GONE

        prefs = requireActivity().getSharedPreferences(activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
        localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
            localDB.getAdministradorByUsuario(it.getAdminUsuario()).observe(viewLifecycleOwner){ a ->
                localDB.getChoferByRFCYAdministrador(id, a.getRfc()).observe(viewLifecycleOwner){ ch ->
                    if(ch != null) if(ch.getNombre() == titulo){
                        binding.txtRFC.text = ch.getRfc()
                        binding.txtNombre.text = ch.getNombre()
                        binding.txtCelular.text = ch.getNumCelular().toString()
                        binding.txtLinea.text = ch.getLinea()
                        binding.txtCalificacion.progress = ch.getCalificacion().toInt()

                        binding.btnBorrar.setOnClickListener{
                            fragment.context?.vibrate(80L)
                            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaChofer(localDB, bin, ch).mostrar())
                            dismiss()
                        }

                        binding.btnModificar.setOnClickListener{
                            fragment.context?.vibrate(50L)
                            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaChofer(localDB, bin, ch).mostrar())
                            dismiss()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        bin.btnAgregar.visibility = View.VISIBLE
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): View = binding.tarjeta

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout
}