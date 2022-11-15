package com.example.tpBD.controller

import com.example.tpBD.model.Reproduccion
import com.example.tpBD.service.ReproduccionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class ReproduccionController {

    @Autowired
    lateinit var reproduccionService: ReproduccionService

    @PostMapping("/reproduccion")
    fun crear(@RequestBody reproduccion: Reproduccion) {
        reproduccionService.crear(reproduccion)
    }
}