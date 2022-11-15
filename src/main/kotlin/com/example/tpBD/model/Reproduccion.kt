package com.example.tpBD.model

import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.*

@Entity
@Table(name = "es_reproducido")
class Reproduccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VISUALIZACION")
    var id: Long = 0
    @Column(name = "ID_USUARIO")
    var id_usuario: Long = 1
    @Column(name = "ID_CONTENIDO")
    var id_contenido: Long = 0
    @Column(name = "SISTEMA_OPERATIVO_USADO")
    var so_usado: String = ""
    @Column(name = "FECHA_INICIO")
    var fecha_inicio: LocalDate = LocalDate.now()
    @Column(name = "FECHA_FIN")
    var fecha_fin: LocalDate = LocalDate.now()
    @Column(name = "HORA_INICIO")
    var hora_inicio: LocalTime = LocalTime.now()
    @Column(name = "HORA_FIN")
    var hora_fin: LocalTime = LocalTime.now()
}