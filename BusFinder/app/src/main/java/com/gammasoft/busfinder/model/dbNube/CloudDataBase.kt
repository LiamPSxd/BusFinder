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

        //CodigoAdministrador
        fun addCodigoAdministrador(codigo: Codigo){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CodigoAdministrador").document(codigo.getId()).set(
                    hashMapOf(
                        "valor" to codigo.getValor(),
                        "estado" to codigo.getEstado()
                    )
                )
            }
        }

        fun getCodigosAdministrador(): ArrayList<Codigo>{
            val codigos = arrayListOf<Codigo>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CodigoAdministrador").get().addOnSuccessListener{
                    for(res in it){
                        codigos.add(Codigo(
                            res.id,
                            res.getLong("valor").toString().toLong(),
                            res.getBoolean("estado").toString().toBoolean(),
                       ))
                    }
                }
            }

            return codigos
        }

        //CodigoChofer
        fun addCodigoChofer(codigo: Codigo){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CodigoChofer").document(codigo.getId()).set(
                    hashMapOf(
                        "valor" to codigo.getValor(),
                        "estado" to codigo.getEstado()
                    )
                )
            }
        }

        fun getCodigosChofer(): ArrayList<Codigo>{
            val codigos = arrayListOf<Codigo>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CodigoChofer").get().addOnSuccessListener{
                    for(res in it){
                        codigos.add(Codigo(
                            res.id,
                            res.getLong("valor").toString().toLong(),
                            res.getBoolean("estado").toString().toBoolean(),
                        ))
                    }
                }
            }

            return codigos
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

        fun getAdministrador(documento: String): Administrador{
            val admin = Administrador()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Administrador").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        admin.setUsuario(it.getString("usuario").toString())
                        admin.setRfc(it.getString("rfc").toString())
                        admin.setNombre(it.getString("nombre").toString())
                        admin.setNumCelular(it.getLong("numeroCelular").toString().toLong())
                        admin.setLinea(it.getString("lineaTransporte").toString())
                        admin.setCodigo(it.getLong("codigo").toString().toLong())
                    }
                }
            }

            return admin
        }

        fun getAdministradores(): ArrayList<Administrador>{
            val admins = arrayListOf<Administrador>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Administrador").get().addOnSuccessListener{
                    for(res in it){
                        admins.add(Administrador(
                            res.getString("usuario").toString(),
                            res.getString("rfc").toString(),
                            res.getString("nombre").toString(),
                            res.getLong("numeroCelular").toString().toLong(),
                            res.getString("lineaTransporte").toString(),
                            res.getLong("codigo").toString().toLong()
                        ))
                    }
                }
            }

            return admins
        }

        //Calle
        fun addCalle(calle: Calle){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Calle").document(calle.getId().toString()).set(
                    hashMapOf(
                        "id" to calle.getId(),
                        "nombre" to calle.getNombre()
                    )
                )
            }
        }

        fun getCalle(documento: String): Calle{
            val calle = Calle()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Calle").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        calle.setId(it.getLong("id").toString().toInt())
                        calle.setNombre(it.getString("nombre").toString())
                    }
                }
            }

            return calle
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
                        "calificacion" to chofer.getCalificacion()
                    )
                )
            }
        }

        fun getChofer(documento: String): Chofer{
            val chofer = Chofer()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Chofer").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        chofer.setUsuario(it.getString("usuario").toString())
                        chofer.setRfc(it.getString("rfc").toString())
                        chofer.setNombre(it.getString("nombre").toString())
                        chofer.setNumCelular(it.getLong("numeroCelular").toString().toLong())
                        chofer.setLinea(it.getString("lineaTransporte").toString())
                        chofer.setCodigo(it.getLong("codigo").toString().toLong())
                        chofer.setNoUsuarios(it.getLong("numeroUsuarios").toString().toInt())
                        chofer.setCalificacion(it.getDouble("calificacion").toString().toDouble())
                    }
                }
            }

            return chofer
        }

        fun getChoferByRFC(rfc: String): Chofer{
            val chofer = Chofer()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Chofer").whereEqualTo("rfc", rfc).get().addOnCompleteListener{
                    val res = it.result.documents[0]

                    chofer.setUsuario(res.getString("usuario").toString())
                    chofer.setRfc(res.getString("rfc").toString())
                    chofer.setNombre(res.getString("nombre").toString())
                    chofer.setNumCelular(res.getLong("numeroCelular").toString().toLong())
                    chofer.setLinea(res.getString("lineaTransporte").toString())
                    chofer.setCodigo(res.getLong("codigo").toString().toLong())
                    chofer.setNoUsuarios(res.getLong("numeroUsuarios").toString().toInt())
                    chofer.setCalificacion(res.getDouble("calificacion").toString().toDouble())
                }
            }

            return chofer
        }

        fun getChoferByNombre(nombre: String): Chofer{
            val chofer = Chofer()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Chofer").whereEqualTo("nombre", nombre).get().addOnCompleteListener{
                    val res = it.result.documents[0]

                    chofer.setUsuario(res.getString("usuario").toString())
                    chofer.setRfc(res.getString("rfc").toString())
                    chofer.setNombre(res.getString("nombre").toString())
                    chofer.setNumCelular(res.getLong("numeroCelular").toString().toLong())
                    chofer.setLinea(res.getString("lineaTransporte").toString())
                    chofer.setCodigo(res.getLong("codigo").toString().toLong())
                    chofer.setNoUsuarios(res.getLong("numeroUsuarios").toString().toInt())
                    chofer.setCalificacion(res.getDouble("calificacion").toString().toDouble())
                }
            }

            return chofer
        }

        fun getChoferes(): ArrayList<Chofer>{
            val choferes = ArrayList<Chofer>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Chofer").get().addOnSuccessListener{
                    for(res in it){
                        choferes.add(Chofer(
                            res.getString("usuario").toString(),
                            res.getString("rfc").toString(),
                            res.getString("nombre").toString(),
                            res.getLong("numeroCelular").toString().toLong(),
                            res.getString("lineaTransporte").toString(),
                            res.getLong("codigo").toString().toLong(),
                            res.getLong("numeroUsuarios").toString().toInt(),
                            res.getDouble("calificacion").toString().toDouble()
                        ))
                    }
                }
            }

            return choferes
        }

        //Coordenada
        fun addCoordenada(coordenada: Coordenada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Coordenada").document(coordenada.getId().toString()).set(
                    hashMapOf(
                        "id" to coordenada.getId(),
                        "latitud" to coordenada.getLatitud(),
                        "longitud" to coordenada.getLongitud()
                    )
                )
            }
        }

        fun getCoordenada(documento: String): Coordenada{
            val coordenada = Coordenada()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Coordenada").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        coordenada.setId(it.getLong("id").toString().toInt())
                        coordenada.setLatitud(it.getDouble("latitud").toString().toDouble())
                        coordenada.setLongitud(it.getDouble("longitud").toString().toDouble())
                    }
                }
            }

            return coordenada
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

        fun getHorario(documento: String): Horario{
            val horario = Horario()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Horario").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        horario.setId(it.getLong("id").toString().toInt())
                        horario.setHoraEntrada(it.getString("horaEntrada").toString())
                        horario.setHoraSalida(it.getString("horaSalida").toString())
                        horario.setFecha(it.getString("fecha").toString())
                    }
                }
            }

            return horario
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

        fun getCuenta(documento: String): Cuenta{
            val cuenta = Cuenta()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Cuenta").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        var tipo = 3
                        when(it.getString("tipo")!!){
                            "Administrador" -> tipo = 0
                            "Chofer" -> tipo = 1
                            "Publico General" -> tipo = 2
                        }

                        cuenta.setCorreo(it.getString("correo").toString())
                        cuenta.setContrasenia(it.getString("contrasenia").toString())
                        cuenta.setFoto(it.getString("foto").toString())
                        cuenta.setTipo(tipo)
                        cuenta.setMetodo(it.getString("metodo").toString())
                        cuenta.setEstado(it.getBoolean("estado").toString().toBoolean())
                    }
                }
            }

            return cuenta
        }

        fun getCuentas(): ArrayList<Cuenta>{
            val cuentas = ArrayList<Cuenta>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Cuenta").get().addOnSuccessListener{
                    for(res in it.documents){
                        var tipo = 3
                        when(res.getString("tipo")!!){
                            "Administrador" -> tipo = 0
                            "Chofer" -> tipo = 1
                            "Publico General" -> tipo = 2
                        }

                        cuentas.add(Cuenta(
                            res.getString("correo").toString(),
                            res.getString("contrasenia").toString(),
                            res.getString("foto").toString(),
                            tipo,
                            res.getString("metodo").toString(),
                            res.getBoolean("estado").toString().toBoolean()
                        ))
                    }
                }
            }

            return cuentas
        }

        //Parada
        fun addParada(parada: Parada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Parada").document(parada.getId().toString()).set(
                    hashMapOf(
                        "id" to parada.getId(),
                        "nombre" to parada.getNombre()
                    )
                )
            }
        }

        fun getParada(documento: String): Parada{
            val parada = Parada()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Parada").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        parada.setId(it.getLong("id").toString().toInt())
                        parada.setNombre(it.getString("nombre").toString())
                    }
                }
            }

            return parada
        }

        fun getParadas(): ArrayList<Parada>{
            val paradas = ArrayList<Parada>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Parada").get().addOnSuccessListener{
                    for(res in it){
                        paradas.add(Parada(
                            res.getString("id").toString().toInt(),
                            res.getString("nombre").toString(),
                        ))
                    }
                }
            }

            return paradas
        }

        //PublicoGeneral
        fun addPublicoGeneral(publico: PublicoGeneral){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("PublicoGeneral").document(publico.getUsuario()).set(
                    hashMapOf("usuario" to publico.getUsuario())
                )
            }
        }

        fun getPublicoGeneral(documento: String): PublicoGeneral{
            val publico = PublicoGeneral()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("PublicoGeneral").document(documento).get().addOnSuccessListener{
                    if(it.exists()) publico.setUsuario(it.getString("usuario").toString())
                }
            }

            return publico
        }

        //Tarifa
        fun addTarifa(tarifa: Tarifa){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Tarifa").document(tarifa.getNombre()).set(
                    hashMapOf(
                        "nombre" to tarifa.getNombre(),
                        "precio" to tarifa.getPrecio()
                    )
                )
            }
        }

        fun getTarifa(documento: String): Tarifa{
            val tarifa = Tarifa()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Tarifa").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        tarifa.setNombre(it.getString("nombre").toString())
                        tarifa.setPrecio(it.getDouble("precio").toString().toDouble())
                    }
                }
            }

            return tarifa
        }

        fun getTarifas(): ArrayList<Tarifa>{
            val tarifas = ArrayList<Tarifa>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Tarifa").get().addOnSuccessListener{
                    for(res in it){
                        tarifas.add(Tarifa(
                            res.getString("nombre").toString(),
                            res.getDouble("precio").toString().toDouble()
                        ))
                    }
                }
            }

            return tarifas
        }

        //Ruta
        fun addRuta(ruta: Ruta){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Ruta").document(ruta.getId().toString()).set(
                    hashMapOf(
                        "id" to ruta.getId(),
                        "nombre" to ruta.getNombre()
                    )
                )
            }
        }

        fun getRuta(documento: String): Ruta{
            val ruta = Ruta()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Ruta").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        ruta.setId(it.getLong("id").toString().toInt())
                        ruta.setNombre(it.getString("nombre").toString())
                    }
                }
            }

            return ruta
        }

        fun getRutas(): ArrayList<Ruta>{
            val rutas = arrayListOf<Ruta>()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Ruta").get().addOnSuccessListener{
                    for(res in it){
                        rutas.add(Ruta(
                            res.getLong("id").toString().toInt(),
                            res.getString("nombre").toString()
                        ))
                    }
                }
            }

            return rutas
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

        fun getUnidad(documento: String): Unidad{
            val unidad = Unidad()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("Unidad").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        unidad.setPlaca(it.getString("placa").toString())
                        unidad.setMarca(it.getString("marca").toString())
                        unidad.setModelo(it.getString("modelo").toString())
                        unidad.setNumero(it.getLong("numero").toString().toInt())
                        unidad.setHora(it.getString("hora").toString())
                        unidad.setFecha(it.getString("fecha").toString())
                    }
                }
            }

            return unidad
        }

        //CalleCoordenada
        fun addCalleCoordenada(documento: String, calleCoor: CalleCoordenada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CalleCoordenada").document(documento).set(
                    hashMapOf(
                        "calleID" to calleCoor.getCalleID(),
                        "coordenadaID" to calleCoor.getCoordenadaID()
                    )
                )
            }
        }

        fun getCalleCoordenada(documento: String): CalleCoordenada{
            val calleCoor = CalleCoordenada()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CalleCoordenada").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        calleCoor.setCalleID(it.getLong("calleID").toString().toInt())
                        calleCoor.setCoordenadaID(it.getLong("coordenadaID").toString().toInt())
                    }
                }
            }

            return calleCoor
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

        fun getCuentaAdministrador(documento: String): CuentaAdministrador{
            val cuentaAdmin = CuentaAdministrador()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CuentaAdministrador").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        cuentaAdmin.setCuentaCorreo(it.getString("cuentaCorreo").toString())
                        cuentaAdmin.setAdminUsuario(it.getString("administradorUsuario").toString())
                    }
                }
            }

            return cuentaAdmin
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

        fun getCuentaChofer(documento: String): CuentaChofer{
            val cuentaChofer = CuentaChofer()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CuentaChofer").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        cuentaChofer.setCuentaCorreo(it.getString("cuentaCorreo").toString())
                        cuentaChofer.setChoferUsuario(it.getString("choferUsuario").toString())
                    }
                }
            }

            return cuentaChofer
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

        fun getCuentaPublico(documento: String): CuentaPublico{
            val cuentaPublico = CuentaPublico()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("CuentaPublico").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        cuentaPublico.setCuentaCorreo(it.getString("cuentaCorreo").toString())
                        cuentaPublico.setPublicoUsuario(it.getString("publicoGeneralUsuario").toString())
                    }
                }
            }

            return cuentaPublico
        }

        //HorarioCUR
        fun addHorarioCUR(documento: String, horarioCUR: HorarioCUR){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("HorarioCUR").document(documento).set(
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

        fun getHorarioCUR(documento: String): HorarioCUR{
            val horarioCUR = HorarioCUR()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("HorarioCUR").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        horarioCUR.setHorarioId(it.getLong("horarioID").toString().toInt())
                        horarioCUR.setChoferUsuario(it.getString("choferUsuario").toString())
                        horarioCUR.setUnidadPlaca(it.getString("unidadPlaca").toString())
                        horarioCUR.setRutaIdaId(it.getLong("rutaIdaID").toString().toInt())
                        horarioCUR.setRutaVenidaId(it.getLong("rutaVenidaID").toString().toInt())
                    }
                }
            }

            return horarioCUR
        }

        //ParadaCoordenada
        fun addParadaCoordenada(documento: String, paradaCoor: ParadaCoordenada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("ParadaCoordenada").document(documento).set(
                    hashMapOf(
                        "paradaID" to paradaCoor.getParadaID(),
                        "coordenadaID" to paradaCoor.getCoordenadaID()
                    )
                )
            }
        }

        fun getParadaCoordenada(documento: String): ParadaCoordenada{
            val paradaCoor = ParadaCoordenada()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("ParadaCoordenada").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        paradaCoor.setParadaID(it.getLong("paradaID").toString().toInt())
                        paradaCoor.setCoordenadaID(it.getLong("coordenadaID").toString().toInt())
                    }
                }
            }

            return paradaCoor
        }

        //RutaCalle
        fun addRutaCalle(documento: String, rutaCalle: RutaCalle){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("RutaCalle").document(documento).set(
                    hashMapOf(
                        "rutaID" to rutaCalle.getRutaID(),
                        "calleID" to rutaCalle.getCalleID()
                    )
                )
            }
        }

        fun getRutaCalle(documento: String): RutaCalle{
            val rutaCalle = RutaCalle()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("RutaCalle").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        rutaCalle.setRutaID(it.getLong("rutaID").toString().toInt())
                        rutaCalle.setCalleID(it.getLong("calleID").toString().toInt())
                    }
                }
            }

            return rutaCalle
        }

        //RutaParada
        fun addRutaParada(documento: String, rutaParada: RutaParada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("RutaParada").document(documento).set(
                    hashMapOf(
                        "rutaID" to rutaParada.getRutaID(),
                        "paradaID" to rutaParada.getParadaID()
                    )
                )
            }
        }

        fun getRutaParada(documento: String): RutaParada{
            val rutaParada = RutaParada()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("RutaParada").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        rutaParada.setRutaID(it.getLong("rutaID").toString().toInt())
                        rutaParada.setParadaID(it.getLong("paradaID").toString().toInt())
                    }
                }
            }

            return rutaParada
        }

        //UnidadCoordenada
        fun addUnidadCoordenada(documento: String, unidadCoor: UnidadCoordenada){
            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("UnidadCoordenada").document(documento).set(
                    hashMapOf(
                        "unidadPlaca" to unidadCoor.getUnidadPlaca(),
                        "coordenadaID" to unidadCoor.getCoordenadaID()
                    )
                )
            }
        }

        fun getUnidadCoordenada(documento: String): UnidadCoordenada{
            val unidadCoor = UnidadCoordenada()

            CoroutineScope(Dispatchers.IO).launch{
                cloudDataBase.collection("UnidadCoordenada").document(documento).get().addOnSuccessListener{
                    if(it.exists()){
                        unidadCoor.setUnidadPlaca(it.getString("unidadPlaca").toString())
                        unidadCoor.setCoordenadaID(it.getLong("coordenadaID").toString().toInt())
                    }
                }
            }

            return unidadCoor
        }
    }
}