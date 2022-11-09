package com.gammasoft.busfinder.model.dbNube

import android.annotation.SuppressLint
import com.example.busfinder.model.dbLocal.entidades.*
import com.example.busfinder.model.dbLocal.relaciones.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

abstract class CloudDataBase{
    companion object{
        @SuppressLint("StaticFieldLeak")
        val cloudDataBase = FirebaseFirestore.getInstance()

        fun getAuth(): FirebaseAuth = FirebaseAuth.getInstance()

        fun delete(coleccion: String, documento: String){
            cloudDataBase.collection(coleccion).document(documento).delete()
        }

        //Administrador
        fun addAdministrador(admin: Administrador){
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

        fun getAdministrador(documento: String): Administrador{
            val admin = Administrador()

            cloudDataBase.collection("Administrador").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    admin.setUsuario(it.get("usuario") as String)
                    admin.setRfc(it.get("rfc") as String)
                    admin.setNombre(it.get("nombre") as String)
                    admin.setNumCelular(it.get("numeroCelular") as Long)
                    admin.setLinea(it.get("lineaTransporte") as String)
                    admin.setCodigo(it.get("codigo") as Int)
                }
            }

            return admin
        }

        fun getAdministradores(): ArrayList<Administrador>{
            val admins = ArrayList<Administrador>()

            cloudDataBase.collection("Administrador").get().addOnSuccessListener{
                for(res in it){
                    admins.add(Administrador(
                        res.get("usuario") as String,
                        res.get("rfc") as String,
                        res.get("nombre") as String,
                        res.get("numeroCelular") as Long,
                        res.get("lineaTransporte") as String,
                        res.get("codigo") as Int
                    ))
                }
            }

            return admins
        }

        //Calle
        fun addCalle(calle: Calle){
            cloudDataBase.collection("Calle").document(calle.getId().toString()).set(
                hashMapOf(
                    "id" to calle.getId(),
                    "nombre" to calle.getNombre()
                )
            )
        }

        fun getCalle(documento: String): Calle{
            val calle = Calle()

            cloudDataBase.collection("Calle").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    calle.setId(it.get("id") as Int)
                    calle.setNombre(it.get("nombre") as String)
                }
            }

            return calle
        }

        //Chofer
        fun addChofer(chofer: Chofer){
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

        fun getChofer(documento: String): Chofer{
            val chofer = Chofer()

            cloudDataBase.collection("Chofer").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    chofer.setUsuario(it.get("usuario") as String)
                    chofer.setRfc(it.get("rfc") as String)
                    chofer.setNombre(it.get("nombre") as String)
                    chofer.setNumCelular(it.get("numeroCelular") as Long)
                    chofer.setLinea(it.get("lineaTransporte") as String)
                    chofer.setCodigo(it.get("codigo") as Int)
                    chofer.setNoUsuarios(it.get("numeroUsuarios") as Int)
                    chofer.setCalificacion(it.get("calificacion") as Double)
                }
            }

            return chofer
        }

        fun getChoferes(): ArrayList<Chofer>{
            val choferes = ArrayList<Chofer>()

            cloudDataBase.collection("Chofer").get().addOnSuccessListener{
                for(res in it){
                    choferes.add(Chofer(
                        res.get("usuario") as String,
                        res.get("rfc") as String,
                        res.get("nombre") as String,
                        res.get("numeroCelular") as Long,
                        res.get("lineaTransporte") as String,
                        res.get("codigo") as Int,
                        res.get("numeroUsuarios") as Int,
                        res.get("calificacion") as Double
                    ))
                }
            }

            return choferes
        }

        //Coordenada
        fun addCoordenada(coordenada: Coordenada){
            cloudDataBase.collection("Coordenada").document(coordenada.getId().toString()).set(
                hashMapOf(
                    "id" to coordenada.getId(),
                    "latitud" to coordenada.getLatitud(),
                    "longitud" to coordenada.getLongitud()
                )
            )
        }

        fun getCoordenada(documento: String): Coordenada{
            val coordenada = Coordenada()

            cloudDataBase.collection("Coordenada").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    coordenada.setId(it.get("id") as Int)
                    coordenada.setLatitud(it.get("latitud") as Double)
                    coordenada.setLongitud(it.get("longitud") as Double)
                }
            }

            return coordenada
        }

        //Horario
        fun addHorario(horario: Horario){
            cloudDataBase.collection("Horario").document(horario.getId().toString()).set(
                hashMapOf(
                    "id" to horario.getId(),
                    "horaEntrada" to horario.getHoraEntrada(),
                    "horaSalida" to horario.getHoraSalida(),
                    "fecha" to horario.getFecha()
                )
            )
        }

        fun getHorario(documento: String): Horario{
            val horario = Horario()

            cloudDataBase.collection("Horario").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    horario.setId(it.get("id") as Int)
                    horario.setHoraEntrada(it.get("horaEntrada") as String)
                    horario.setHoraSalida(it.get("horaSalida") as String)
                    horario.setFecha(it.get("fecha") as String)
                }
            }

            return horario
        }

        //Cuenta
        fun addCuenta(cuenta: Cuenta){
            cloudDataBase.collection("Cuenta").document(cuenta.getCorreo()).set(
                hashMapOf(
                    "correo" to cuenta.getCorreo(),
                    "contrasenia" to cuenta.getContrasenia(),
                    "foto" to cuenta.getFoto(),
                    "tipo" to cuenta.mostrarTipo(),
                    "estado" to cuenta.getEstado()
                )
            )
        }

        fun getCuenta(documento: String): Cuenta{
            val cuenta = Cuenta()

            cloudDataBase.collection("Cuenta").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    cuenta.setCorreo(it.get("correo") as String)
                    cuenta.setContrasenia(it.get("contrasenia") as String)
                    cuenta.setFoto(it.get("foto") as Int)
                    cuenta.setTipo(it.get("tipo") as Int)
                    cuenta.setEstado(it.get("estado") as Boolean)
                }
            }

            return cuenta
        }

        fun getCuentas(): ArrayList<Cuenta>{
            val cuentas = ArrayList<Cuenta>()

            cloudDataBase.collection("Cuenta").get().addOnSuccessListener{
                for(res in it){
                    cuentas.add(Cuenta(
                        res.get("correo").toString(),
                        res.get("contrasenia").toString(),
                        res.get("foto").toString().toInt(),
                        res.get("tipo").toString().toInt(),
                        res.get("estado").toString().toBoolean()
                    ))
                }
            }

            return cuentas
        }

        //Parada
        fun addParada(parada: Parada){
            cloudDataBase.collection("Parada").document(parada.getId().toString()).set(
                hashMapOf(
                    "id" to parada.getId(),
                    "nombre" to parada.getNombre()
                )
            )
        }

        fun getParada(documento: String): Parada{
            val parada = Parada()

            cloudDataBase.collection("Parada").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    parada.setId(it.get("id") as Int)
                    parada.setNombre(it.get("nombre") as String)
                }
            }

            return parada
        }

        //PublicoGeneral
        fun addPublicoGeneral(publico: PublicoGeneral){
            cloudDataBase.collection("PublicoGeneral").document(publico.getUsuario()).set(
                hashMapOf(
                    "usuario" to publico.getUsuario()
                )
            )
        }

        fun getPublicoGeneral(documento: String): PublicoGeneral{
            val publico = PublicoGeneral()

            cloudDataBase.collection("PublicoGeneral").document(documento).get().addOnSuccessListener{
                if(it.exists()) publico.setUsuario(it.get("usuario") as String)
            }

            return publico
        }

        //Tarifa
        fun addTarifa(tarifa: Tarifa){
            cloudDataBase.collection("Tarifa").document(tarifa.getNombre()).set(
                hashMapOf(
                    "nombre" to tarifa.getNombre(),
                    "precio" to tarifa.getPrecio()
                )
            )
        }

        fun getTarifa(documento: String): Tarifa{
            val tarifa = Tarifa()

            cloudDataBase.collection("Tarifa").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    tarifa.setNombre(it.get("nombre") as String)
                    tarifa.setPrecio(it.get("precio") as Double)
                }
            }

            return tarifa
        }

        //Ruta
        fun addRuta(ruta: Ruta){
            cloudDataBase.collection("Ruta").document(ruta.getId().toString()).set(
                hashMapOf(
                    "id" to ruta.getId(),
                    "nombre" to ruta.getNombre()
                )
            )
        }

        fun getRuta(documento: String): Ruta{
            val ruta = Ruta()

            cloudDataBase.collection("Ruta").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    ruta.setId(it.get("id") as Int)
                    ruta.setNombre(it.get("nombre") as String)
                }
            }

            return ruta
        }

        //Unidad
        fun addUnidad(unidad: Unidad){
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

        fun getUnidad(documento: String): Unidad{
            val unidad = Unidad()

            cloudDataBase.collection("Unidad").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    unidad.setPlaca(it.get("placa") as String)
                    unidad.setMarca(it.get("marca") as String)
                    unidad.setModelo(it.get("modelo") as String)
                    unidad.setNumero(it.get("numero") as Int)
                    unidad.setHora(it.get("hora") as String)
                    unidad.setFecha(it.get("fecha") as String)
                }
            }

            return unidad
        }

        //CalleCoordenada
        fun addCalleCoordenada(documento: String, calleCoor: CalleCoordenada){
            cloudDataBase.collection("CalleCoordenada").document(documento).set(
                hashMapOf(
                    "calleID" to calleCoor.getCalleID(),
                    "coordenadaID" to calleCoor.getCoordenadaID()
                )
            )
        }

        fun getCalleCoordenada(documento: String): CalleCoordenada{
            val calleCoor = CalleCoordenada()

            cloudDataBase.collection("CalleCoordenada").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    calleCoor.setCalleID(it.get("calleID") as Int)
                    calleCoor.setCoordenadaID(it.get("coordenadaID") as Int)
                }
            }

            return calleCoor
        }

        //CuentaAdministrador
        fun addCuentaAdministrador(documento: String, cuentaAdmin: CuentaAdministrador){
            cloudDataBase.collection("CuentaAdministrador").document(documento).set(
                hashMapOf(
                    "cuentaCorreo" to cuentaAdmin.getCuentaCorreo(),
                    "administradorUsuario" to cuentaAdmin.getAdminUsuario()
                )
            )
        }

        fun getCuentaAdministrador(documento: String): CuentaAdministrador{
            val cuentaAdmin = CuentaAdministrador()

            cloudDataBase.collection("CuentaAdministrador").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    cuentaAdmin.setCuentaCorreo(it.get("cuentaCorreo") as String)
                    cuentaAdmin.setAdminUsuario(it.get("administradorUsuario") as String)
                }
            }

            return cuentaAdmin
        }

        //CuentaChofer
        fun addCuentaChofer(documento: String, cuentaChofer: CuentaChofer){
            cloudDataBase.collection("CuentaChofer").document(documento).set(
                hashMapOf(
                    "cuentaCorreo" to cuentaChofer.getCuentaCorreo(),
                    "choferUsuario" to cuentaChofer.getChoferUsuario()
                )
            )
        }

        fun getCuentaChofer(documento: String): CuentaChofer{
            val cuentaChofer = CuentaChofer()

            cloudDataBase.collection("CuentaChofer").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    cuentaChofer.setCuentaCorreo(it.get("cuentaCorreo") as String)
                    cuentaChofer.setChoferUsuario(it.get("choferUsuario") as String)
                }
            }

            return cuentaChofer
        }

        //CuentaPublico
        fun addCuentaPublico(documento: String, cuentaPublico: CuentaPublico){
            cloudDataBase.collection("CuentaPublico").document(documento).set(
                hashMapOf(
                    "cuentaCorreo" to cuentaPublico.getCuentaCorreo(),
                    "publicoGeneralUsuario" to cuentaPublico.getPublicoUsuario()
                )
            )
        }

        fun getCuentaPublico(documento: String): CuentaPublico{
            val cuentaPublico = CuentaPublico()

            cloudDataBase.collection("CuentaPublico").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    cuentaPublico.setCuentaCorreo(it.get("cuentaCorreo") as String)
                    cuentaPublico.setPublicoUsuario(it.get("publicoGeneralUsuario") as String)
                }
            }

            return cuentaPublico
        }

        //HorarioCUR
        fun addHorarioCUR(documento: String, horarioCUR: HorarioCUR){
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

        fun getHorarioCUR(documento: String): HorarioCUR{
            val horarioCUR = HorarioCUR()

            cloudDataBase.collection("HorarioCUR").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    horarioCUR.setHorarioId(it.get("horarioID") as Int)
                    horarioCUR.setChoferUsuario(it.get("choferUsuario") as String)
                    horarioCUR.setUnidadPlaca(it.get("unidadPlaca") as String)
                    horarioCUR.setRutaIdaId(it.get("rutaIdaID") as Int)
                    horarioCUR.setRutaVenidaId(it.get("rutaVenidaID") as Int)
                }
            }

            return horarioCUR
        }

        //ParadaCoordenada
        fun addParadaCoordenada(documento: String, paradaCoor: ParadaCoordenada){
            cloudDataBase.collection("ParadaCoordenada").document(documento).set(
                hashMapOf(
                    "paradaID" to paradaCoor.getParadaID(),
                    "coordenadaID" to paradaCoor.getCoordenadaID()
                )
            )
        }

        fun getParadaCoordenada(documento: String): ParadaCoordenada{
            val paradaCoor = ParadaCoordenada()

            cloudDataBase.collection("ParadaCoordenada").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    paradaCoor.setParadaID(it.get("paradaID") as Int)
                    paradaCoor.setCoordenadaID(it.get("coordenadaID") as Int)
                }
            }

            return paradaCoor
        }

        //RutaCalle
        fun addRutaCalle(documento: String, rutaCalle: RutaCalle){
            cloudDataBase.collection("RutaCalle").document(documento).set(
                hashMapOf(
                    "rutaID" to rutaCalle.getRutaID(),
                    "calleID" to rutaCalle.getCalleID()
                )
            )
        }

        fun getRutaCalle(documento: String): RutaCalle{
            val rutaCalle = RutaCalle()

            cloudDataBase.collection("RutaCalle").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    rutaCalle.setRutaID(it.get("rutaID") as Int)
                    rutaCalle.setCalleID(it.get("calleID") as Int)
                }
            }

            return rutaCalle
        }

        //RutaParada
        fun addRutaParada(documento: String, rutaParada: RutaParada){
            cloudDataBase.collection("RutaParada").document(documento).set(
                hashMapOf(
                    "rutaID" to rutaParada.getRutaID(),
                    "paradaID" to rutaParada.getParadaID()
                )
            )
        }

        fun getRutaParada(documento: String): RutaParada{
            val rutaParada = RutaParada()

            cloudDataBase.collection("RutaParada").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    rutaParada.setRutaID(it.get("rutaID") as Int)
                    rutaParada.setParadaID(it.get("paradaID") as Int)
                }
            }

            return rutaParada
        }

        //UnidadCoordenada
        fun addUnidadCoordenada(documento: String, unidadCoor: UnidadCoordenada){
            cloudDataBase.collection("UnidadCoordenada").document(documento).set(
                hashMapOf(
                    "unidadPlaca" to unidadCoor.getUnidadPlaca(),
                    "coordenadaID" to unidadCoor.getCoordenadaID()
                )
            )
        }

        fun getUnidadCoordenada(documento: String): UnidadCoordenada{
            val unidadCoor = UnidadCoordenada()

            cloudDataBase.collection("UnidadCoordenada").document(documento).get().addOnSuccessListener{
                if(it.exists()){
                    unidadCoor.setUnidadPlaca(it.get("unidadPlaca") as String)
                    unidadCoor.setCoordenadaID(it.get("coordenadaID") as Int)
                }
            }

            return unidadCoor
        }
    }
}