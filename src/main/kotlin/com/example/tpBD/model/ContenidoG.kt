package com.example.tpBD.model

import java.time.LocalDate
import javax.persistence.*

//Temporal . Hay que crear la clase abstrracta Contenido con sus clases  hijos

@Entity
@Table(name = "contenido")
class ContenidoG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ID_CONTENIDO: Long = 0

    @Column
    var TITULO: String = ""

    @Column
    var EXTENSION: String = ""
}

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name = "contenido")
abstract class Contenido{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ID_CONTENIDO : Long = 0

    @Column
    var TITULO : String = ""
    @Column
    var EXTENSION : String = ""
    @Column
    var FECHA_PUBLICADO : LocalDate = LocalDate.now()
}