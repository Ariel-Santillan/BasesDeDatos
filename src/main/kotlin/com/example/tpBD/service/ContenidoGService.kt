package com.example.tpBD.service

import com.example.tpBD.model.ContenidoG
import com.example.tpBD.repository.ContenidoGRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContenidoGService {
    @Autowired
    lateinit var contenidoGRepository: ContenidoGRepository

    fun obtenerTodosLosContenidos(): List<ContenidoG> {
        return contenidoGRepository.todosLosContenidos()
    }

    fun guardarContenido(contenidoG: ContenidoG){
        val titulo = contenidoG.TITULO
        val extension = contenidoG.EXTENSION
        contenidoGRepository.agregarContenido(titulo,extension)
    }

    fun eliminarUnContenido(id : Long) : String{
        contenidoGRepository.eliminarContenido(id)
        return "Contenido eliminado"
    }

    fun actualizarContenido(id : Long , contenidoG: ContenidoG){
        val contenidoEncontrado = contenidoGRepository.buscarContenidoPorId(id)
        val titulo = contenidoG.TITULO
        val extension = contenidoG.EXTENSION
        contenidoGRepository.actualizarContenido(titulo,extension,contenidoEncontrado.ID_CONTENIDO)
    }
}