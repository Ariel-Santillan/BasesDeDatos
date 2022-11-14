package com.example.tpBD.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "descarga")
class Descarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ID_DESCARGA: Long = 0
    @Column
    var VELOCIDAD_TRANSFERENCIA: String = ""

}