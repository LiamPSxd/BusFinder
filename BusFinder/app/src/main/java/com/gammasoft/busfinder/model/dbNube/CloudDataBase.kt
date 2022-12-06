package com.gammasoft.busfinder.model.dbNube

import android.annotation.SuppressLint
import com.gammasoft.busfinder.model.dbLocal.entidades.*
import com.gammasoft.busfinder.model.dbLocal.relaciones.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class CloudDataBase{
    companion object{
        @SuppressLint("StaticFieldLeak")
        val cloudDataBase = FirebaseFirestore.getInstance()

        fun getAuth(): FirebaseAuth = FirebaseAuth.getInstance()

        fun delete(coleccion: String, documento: String){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection(coleccion).document(documento).delete()
            }
        }

    //Cuenta
        fun addCuenta(cuenta: Cuenta){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Cuenta").document(cuenta.getCorreo()).set(
                    hashMapOf(
                        "correo" to cuenta.getCorreo(),
                        "contrasenia" to cuenta.getContrasenia(),
                        "foto" to cuenta.getFoto(),
                        "tipo" to cuenta.mostrarTipo(),
                        "metodo" to cuenta.getMetodo(),
                        "estado" to cuenta.getEstado()
                    )
                )
            }
        }

    //Administrador
        fun addAdministrador(admin: Administrador){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Administrador").document(admin.getUsuario()).set(
                    hashMapOf(
                        "usuario" to admin.getUsuario(),
                        "rfc" to admin.getRfc(),
                        "nombre" to admin.getNombre(),
                        "numeroCelular" to admin.getNumCelular(),
                        "lineaTransporte" to admin.getLinea(),
                        "codigo" to admin.getCodigo()
                    )
                )
            }
        }

    //Chofer
        fun addChofer(chofer: Chofer){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Chofer").document(chofer.getUsuario()).set(
                    hashMapOf(
                        "usuario" to chofer.getUsuario(),
                        "rfc" to chofer.getRfc(),
                        "nombre" to chofer.getNombre(),
                        "numeroCelular" to chofer.getNumCelular(),
                        "lineaTransporte" to chofer.getLinea(),
                        "codigo" to chofer.getCodigo(),
                        "numeroUsuarios" to chofer.getNoUsuarios(),
                        "calificacion" to chofer.getCalificacion(),
                        "administrador" to chofer.getAdministrador()
                    )
                )
            }
        }

    //PublicoGeneral
        fun addPublicoGeneral(publico: PublicoGeneral){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("PublicoGeneral").document(publico.getUsuario()).set(
                    hashMapOf("usuario" to publico.getUsuario())
                )
            }
        }

    //Ruta
        fun addRuta(ruta: Ruta){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Ruta").document(ruta.getId().toString()).set(
                    hashMapOf(
                        "id" to ruta.getId(),
                        "nombre" to ruta.getNombre(),
                        "administrador" to ruta.getAdministrador()
                    )
                )
            }
        }

    //Parada
        fun addParada(parada: Parada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Parada").document(parada.getId().toString()).set(
                    hashMapOf(
                        "id" to parada.getId(),
                        "nombre" to parada.getNombre(),
                        "longitud" to parada.getLongitud(),
                        "latitud" to parada.getLatitud(),
                        "administrador" to parada.getAdministrador()
                    )
                )
            }
        }

    //Unidad
        fun addUnidad(unidad: Unidad){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Unidad").document(unidad.getPlaca()).set(
                    hashMapOf(
                        "placa" to unidad.getPlaca(),
                        "marca" to unidad.getMarca(),
                        "modelo" to unidad.getModelo(),
                        "numero" to unidad.getNumero(),
                        "hora" to unidad.getHora(),
                        "fecha" to unidad.getFecha()
                    )
                )
            }
        }

    //Tarifa
        fun addTarifa(tarifa: Tarifa){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Tarifa").document(tarifa.getNombre()).set(
                    hashMapOf(
                        "nombre" to tarifa.getNombre(),
                        "precio" to tarifa.getPrecio(),
                        "administrador" to tarifa.getAdministrador()
                    )
                )
            }
        }

    //Horario
        fun addHorario(horario: Horario){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Horario").document(horario.getId().toString()).set(
                    hashMapOf(
                        "id" to horario.getId(),
                        "horaEntrada" to horario.getHoraEntrada(),
                        "horaSalida" to horario.getHoraSalida(),
                        "fecha" to horario.getFecha()
                    )
                )
            }
        }

    //Coordenada
        fun addCoordenada(coordenada: Coordenada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Coordenada").document(coordenada.getId().toString()).set(
                    hashMapOf(
                        "id" to coordenada.getId(),
                        "latitud" to coordenada.getLatitud(),
                        "longitud" to coordenada.getLongitud(),
                        "administrador" to coordenada.getAdministrador()
                    )
                )
            }
        }

    //CuentaAdministrador
        fun addCuentaAdministrador(cuentaAdmin: CuentaAdministrador){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CuentaAdministrador").document(cuentaAdmin.getCuentaCorreo()).set(
                    hashMapOf(
                        "cuentaCorreo" to cuentaAdmin.getCuentaCorreo(),
                        "administradorUsuario" to cuentaAdmin.getAdminUsuario()
                    )
                )
            }
        }

    //CuentaChofer
        fun addCuentaChofer(cuentaChofer: CuentaChofer){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CuentaChofer").document(cuentaChofer.getCuentaCorreo()).set(
                    hashMapOf(
                        "cuentaCorreo" to cuentaChofer.getCuentaCorreo(),
                        "choferUsuario" to cuentaChofer.getChoferUsuario()
                    )
                )
            }
        }

    //CuentaPublico
        fun addCuentaPublico(cuentaPublico: CuentaPublico){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CuentaPublico").document(cuentaPublico.getCuentaCorreo()).set(
                    hashMapOf(
                        "cuentaCorreo" to cuentaPublico.getCuentaCorreo(),
                        "publicoGeneralUsuario" to cuentaPublico.getPublicoUsuario()
                    )
                )
            }
        }

    //RutaCoordenda
        fun addRutaCoordenada(rutaCoordenada: RutaCoordenada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("RutaCoordenada").document("${rutaCoordenada.getRutaID()}${rutaCoordenada.getCoordenadaID()}").set(
                    hashMapOf(
                        "rutaID" to rutaCoordenada.getRutaID(),
                        "coordenadaID" to rutaCoordenada.getCoordenadaID()
                    )
                )
            }
        }

    //RutaParada
        fun addRutaParada(rutaParada: RutaParada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("RutaParada").document("${rutaParada.getRutaID()}${rutaParada.getParadaID()}").set(
                    hashMapOf(
                        "rutaID" to rutaParada.getRutaID(),
                        "paradaID" to rutaParada.getParadaID()
                    )
                )
            }
        }

    //UnidadCoordenada
        fun addUnidadCoordenada(unidadCoor: UnidadCoordenada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("UnidadCoordenada").document("${unidadCoor.getUnidadPlaca()}${unidadCoor.getCoordenadaID()}").set(
                    hashMapOf(
                        "unidadPlaca" to unidadCoor.getUnidadPlaca(),
                        "coordenadaID" to unidadCoor.getCoordenadaID()
                    )
                )
            }
        }

    //HorarioCUR
        fun addHorarioCUR(horarioCUR: HorarioCUR){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("HorarioCUR").document(horarioCUR.getHorarioId().toString()).set(
                    hashMapOf(
                        "horarioID" to horarioCUR.getHorarioId(),
                        "choferUsuario" to horarioCUR.getChoferUsuario(),
                        "unidadPlaca" to horarioCUR.getUnidadPlaca(),
                        "rutaIdaID" to horarioCUR.getRutaIdaId(),
                        "rutaVenidaID" to horarioCUR.getRutaVenidaId()
                    )
                )
            }
        }

    //CodigoAdministrador
        fun addCodigoAdministrador(codigo: Codigo){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CodigoAdministrador").document(codigo.getId()).set(
                    hashMapOf(
                        "id" to codigo.getId(),
                        "valor" to codigo.getValor(),
                        "estado" to codigo.getEstado()
                    )
                )
            }
        }

    //CodigoChofer
        fun addCodigoChofer(codigo: Codigo){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CodigoChofer").document(codigo.getId()).set(
                    hashMapOf(
                        "id" to codigo.getId(),
                        "valor" to codigo.getValor(),
                        "estado" to codigo.getEstado()
                    )
                )
            }
        }
    }
}