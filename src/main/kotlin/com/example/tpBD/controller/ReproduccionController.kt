package com.example.tpBD.controller

import com.example.tpBD.model.Reproduccion
import com.example.tpBD.service.ContenidoGService
import com.example.tpBD.service.ReproduccionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class ReproduccionController {
    @Autowired
    lateinit var reproduccionService: ReproduccionService
    @Autowired
    lateinit var contenidoGenController: ContenidoGenController
    @Autowired
    lateinit var contenidoGService: ContenidoGService

    @PostMapping("/reproduccion/{id}")
    fun crear(@PathVariable id: Long, @RequestBody reproduccion: Reproduccion) : String{
        reproduccionService.crear(reproduccion)
        var contenido = contenidoGenController.buscarXID(id)
        return contenidoGService.obtenerRutaCompletaArchivo(contenido)
    }
}