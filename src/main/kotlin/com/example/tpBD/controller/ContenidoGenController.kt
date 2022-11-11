package com.example.tpBD.controller

import com.example.tpBD.model.ContenidoG
import com.example.tpBD.repository.ContenidoGRepository
import com.example.tpBD.service.ContenidoGService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class ContenidoGenController {
    @Autowired
    lateinit var contenidoGService : ContenidoGService
    @Autowired
    lateinit var contenidoRepository: ContenidoGRepository

    @GetMapping("/")
    fun hola() ="BUENAS"

    @GetMapping("/getAll")
    fun todosLosContenidos(): List<ContenidoG> {

        return contenidoGService.obtenerTodosLosContenidos()
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String? {
        contenidoGService.eliminarUnContenido(id) //
        return "Contenido eliminado"
    }

    @PostMapping("/guardarElContenido")
    fun guardarContenido(@RequestBody contenidoG: ContenidoG): String {
        contenidoGService.guardarContenido(contenidoG)
        return "Contenido guardado"
    }

    @PutMapping("/actualizarContenido/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody contenidoG: ContenidoG): String? {
        contenidoGService.actualizarContenido(id, contenidoG)

        return "contenido actualizado"
    }

    @GetMapping("/obtenerContenidoPorID/{id}")
    fun buscarXID(@PathVariable id: Long): ContenidoG {
        return contenidoRepository.buscarContenidoPorId(id)
    }

}