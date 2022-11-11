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

    @ManyToMany
    @JoinTable(
        name ="es_descargado",
        joinColumns = arrayOf(JoinColumn(name = "ID_DESCARGA")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "ID_CONTENIDO"))
    )
    var mirado: List<Video> = listOf()
}