package com.example.tpBD.service

import com.example.tpBD.model.Reproduccion
import com.example.tpBD.repository.ReproduccionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReproduccionService {
    @Autowired
    lateinit var reproduccionRepository: ReproduccionRepository

    fun crear(reproduccion: Reproduccion) {
        reproduccionRepository.crear(reproduccion.id, reproduccion.id_usuario, reproduccion.id_contenido, reproduccion.so_usado, reproduccion.fecha_inicio, reproduccion.fecha_fin, reproduccion.hora_inicio, reproduccion.hora_fin)
    }

}