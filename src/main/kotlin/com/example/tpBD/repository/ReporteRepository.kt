package com.example.tpBD.repository

import com.example.tpBD.model.Reporte
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface ReporteRepository :JpaRepository<Reporte, Long> {

    @Query(value = "")
    fun buscarReporte()
}