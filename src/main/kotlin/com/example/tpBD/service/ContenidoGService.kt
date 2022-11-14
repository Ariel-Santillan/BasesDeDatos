package com.example.tpBD.service

import com.example.tpBD.model.Contenido
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
        val titulo = contenidoG.TITULO
        val extension = contenidoG.EXTENSION

        persitirEnFileSystem(contenidoG, archivo)
        var url :String = "${obtenerRutaCompletaArchivo(contenidoG)}"
        contenidoGRepository.agregarContenido(titulo, extension, url)
    }

    fun eliminarUnContenido(id : Long) : String{
        contenidoGRepository.eliminarContenido(id)
        return "Contenido eliminado"
    }

    fun actualizarContenido(id : Long , contenidoG: ContenidoG){
        val contenidoEncontrado = contenidoGRepository.buscarContenidoPorId(id)
        val titulo = contenidoG.TITULO
        val extension = contenidoG.EXTENSION
        modificarNombreArchivoEnFileSystem(contenidoEncontrado, contenidoG)
        contenidoGRepository.actualizarContenido(titulo,extension,contenidoEncontrado.ID_CONTENIDO)
    }

    private fun modificarNombreArchivoEnFileSystem(contenidoEncontrado: ContenidoG, contenidoG: ContenidoG) {
        Files.move(File(obtenerRutaCompletaArchivo(contenidoEncontrado)).toPath(),
                File(obtenerRutaCompletaArchivo(contenidoG)).toPath())
    }

    private fun persitirEnFileSystem(contenidoG :ContenidoG, archivo: ByteArray) {
        var rutaArchivo :String = "$rutaBaseContenidos$rutaContenidos/"
        Files.createDirectories(File(rutaArchivo).toPath())
        File("${obtenerRutaCompletaArchivo(contenidoG)}").writeBytes(archivo)
    }

    private fun obtenerRutaCompletaArchivo(contenidoG: ContenidoG) :String
    = "$rutaBaseContenidos$rutaContenidos/${obtenerNombreArchivo(contenidoG)}"
    private fun obtenerNombreArchivo(contenidoG: ContenidoG) :String
    = "${contenidoG.TITULO}.${contenidoG.EXTENSION.lowercase()}"

    fun buscarPorCategoria(categoria: Number): List<ContenidoG> {
        return contenidoGRepository.buscarPorCategoria(categoria)
    }
}