package com.example.tpBD.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalDateTime
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
    @Column(name = "URL")
    var url: String = ""
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "FECHA_PUBLICADO")
    var fechaPublicacion: LocalDateTime = LocalDateTime.now()
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