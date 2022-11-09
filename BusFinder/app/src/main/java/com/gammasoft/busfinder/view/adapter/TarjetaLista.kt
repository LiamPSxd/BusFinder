package com.gammasoft.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.*
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.fragment.ListaTarjeta

class TarjetaLista(private val titulo: String,
                   private val fragment: ListaTarjeta): RecyclerView.Adapter<TarjetaLista.ViewHolder>(){
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
    private var items = 0

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder =
        ViewHolder(TarjetaListaBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, i: Int){
        val c = holder.binding.frameChofer
        val r = holder.binding.frameRuta
        val p = holder.binding.frameParada
        val t = holder.binding.frameTarifa
        var contador = ""

        when(titulo){
            "Choferes" -> {
                c.Chofer.visibility = VISIBLE
                r.Ruta.visibility = GONE
                p.Parada.visibility = GONE
                t.Tarifa.visibility = GONE

                rellenarChofer(c, i)
                contador = "Chofer $i"
            }

            "Rutas" -> {
                c.Chofer.visibility = GONE
                r.Ruta.visibility = VISIBLE
                p.Parada.visibility = GONE
                t.Tarifa.visibility = GONE

                rellenarRuta(r, i)
                contador = "Ruta $i"
            }

            "Paradas" -> {
                c.Chofer.visibility = GONE
                r.Ruta.visibility = GONE
                p.Parada.visibility = VISIBLE
                t.Tarifa.visibility = GONE

                rellenarParada(p, i)
                contador = "Parada $i"
            }

            "Tarifas" -> {
                c.Chofer.visibility = GONE
                r.Ruta.visibility = GONE
                p.Parada.visibility = GONE
                t.Tarifa.visibility = VISIBLE

                rellenarTarifa(t, i)
                contador = "Tarifa $i"
            }

            else -> MensajeAlerta("Error", "Tarjeta no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }

        holder.binding.pin.text = contador

        /*holder.binding.tarjeta.onReducingClick{
                holder.binding.tarjeta.context.toast("This is reducing click")
                activity.pushFragment(CardWithListFragment.newInstance(false))
            }
        }*/
    }

    override fun getItemCount(): Int = items

    private fun rellenarChofer(chofer: FrameVisualizarChoferBinding, i: Int){
        localDB.getChoferes().observe(fragment){ choferes ->
            items = choferes.size

            chofer.txtRFC.text = choferes[i].getRfc()
            chofer.txtNombre.text = choferes[i].getNombre()
            chofer.txtCelular.text = choferes[i].getNumCelular().toString()
            chofer.txtCalificacion.progress = choferes[i].getCalificacion().toString().toInt()
        }
    }

    private fun rellenarRuta(ruta: FrameVisualizarRutaBinding, i: Int){
        var resCalles = ""

        localDB.getRutas().observe(fragment){ rutas ->
            items = rutas.size

            ruta.txtNombre.text = rutas[i].getNombre()

            localDB.getCallesIDByRutaID(rutas[i].getId()).observe(fragment){ calles ->
                for(calle in calles){
                    localDB.getCalleById(calle.getCalleID()).observe(fragment){
                        resCalles += " ${it.getNombre()} - "
                    }
                }
            }

            ruta.txtCalles.text = resCalles
        }
    }

    private fun rellenarParada(parada: FrameVisualizarParadaBinding, i: Int){
        localDB.getParadas().observe(fragment){ paradas ->
            items = paradas.size

            parada.txtNombre.text = paradas[i].getNombre()

            localDB.getRutaIDByParadaID(paradas[i].getId()).observe(fragment){
                localDB.getRutaById(it.getRutaID()).observe(fragment){ id ->
                    parada.txtRuta.text = id.getNombre()
                }
            }
        }
    }

    private fun rellenarTarifa(tarifa: FrameVisualizarTarifaBinding, i: Int){
        localDB.getTarifas().observe(fragment){ tarifas ->
            items = tarifas.size

            tarifa.txtNombre.text = tarifas[i].getNombre()
            val x = "$ + ${tarifas[i].getPrecio()} MXN"
            tarifa.txtPrecio.text = x
        }
    }

    inner class ViewHolder(var binding: TarjetaListaBinding): RecyclerView.ViewHolder(binding.root)
}