package com.example.tpBD.service

import com.example.tpBD.model.ContenidoG
import com.example.tpBD.repository.ContenidoGRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

@Service
class ContenidoGService {

    @Value("\${tp.bd.contenidos}")
    private final var rutaBaseContenidos :String = ""
    private final var rutaContenidos :String = "/public/contenidos"
    @Autowired
    lateinit var contenidoGRepository: ContenidoGRepository

    fun obtenerTodosLosContenidos(): List<ContenidoG> {
        return contenidoGRepository.todosLosContenidos()
    }

    fun guardarContenido(contenidoG: ContenidoG, archivo: ByteArray){
        val titulo = contenidoG.titulo
        val extension = contenidoG.extension

        persitirEnFileSystem(contenidoG, archivo)
        var url :String = "${obtenerRutaCompletaArchivo(contenidoG)}"
        contenidoGRepository.agregarContenido(titulo, extension, url)
    }

    fun eliminarUnContenido(id : Long) : String{
        var contenidoABorrar = contenidoGRepository.buscarContenidoPorId(id)
        eliminarArchivoAsociadoDelFileSystem(contenidoABorrar)
        contenidoGRepository.eliminarContenido(id)
        return "Contenido eliminado"
    }

    fun actualizarContenido(id : Long , contenidoG: ContenidoG){
        val contenidoEncontrado = contenidoGRepository.buscarContenidoPorId(id)
        val titulo = contenidoG.titulo
        val extension = contenidoG.extension
        modificarNombreArchivoEnFileSystem(contenidoEncontrado, contenidoG)
        contenidoGRepository.actualizarContenido(titulo,extension,contenidoEncontrado.idContenido)
    }

    private fun modificarNombreArchivoEnFileSystem(contenidoEncontrado: ContenidoG, contenidoG: ContenidoG) {
        Files.move(File(obtenerRutaCompletaArchivo(contenidoEncontrado)).toPath(),
                File(obtenerRutaCompletaArchivo(contenidoG)).toPath())
    }

    private fun persitirEnFileSystem(contenidoG :ContenidoG, archivo: ByteArray) {
        var rutaArchivo :String = "$rutaBaseContenidos$rutaContenidos/"
        Files.createDirectories(File(rutaArchivo).toPath())
        var file = File("${obtenerRutaCompletaArchivo(contenidoG)}")
        file.writeBytes(archivo)
    }

    private fun eliminarArchivoAsociadoDelFileSystem(contenidoG: ContenidoG) {
        Files.deleteIfExists(File(obtenerRutaCompletaArchivo(contenidoG)).toPath())
    }

    private fun obtenerRutaCompletaArchivo(contenidoG: ContenidoG) :String
    = "$rutaBaseContenidos$rutaContenidos/${obtenerNombreArchivo(contenidoG)}"
    private fun obtenerNombreArchivo(contenidoG: ContenidoG) :String
    = "${contenidoG.titulo}.${contenidoG.titulo.lowercase()}"

    fun buscarPorCategoria(categoria: Number): List<ContenidoG> {
        return contenidoGRepository.buscarPorCategoria(categoria)
    }

    fun buscarPorCategorias(categoria :String) :List<ContenidoG> {
        return contenidoGRepository.buscarPorCategorias(categoria)
    }

    fun buscarPorTitulo(titulo :String) :List<ContenidoG> {
        return contenidoGRepository.buscarPorTitulo(titulo)
    }
}