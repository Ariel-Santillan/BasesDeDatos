package com.example.tpBD.controller

import com.example.tpBD.model.Descarga
import com.example.tpBD.service.DescargaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class DescargaController {
    @Autowired
    lateinit var descargaService: DescargaService

    @PostMapping("/descarga")
    fun crear(@RequestBody descarga :Descarga) {
        descargaService.crear(descarga)
    }
}