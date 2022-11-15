package com.example.tpBD.service

import com.example.tpBD.model.Descarga
import com.example.tpBD.repository.DescargaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DescargaService {

    @Autowired
    lateinit var descargaRepository: DescargaRepository

    fun crear(descarga :Descarga) {
        var velocidadTransferencia = descarga.velocidadTransferencia
        descargaRepository.crear(descarga.id, velocidadTransferencia)
    }
}