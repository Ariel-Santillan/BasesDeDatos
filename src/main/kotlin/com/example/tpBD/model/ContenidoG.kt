package com.example.tpBD.model

import javax.persistence.*

//Temporal . Hay que crear la clase abstrracta Contenido con sus clases  hijos

@Entity
@Table(name = "contenido")
class ContenidoG(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ID_CONTENIDO : Long,
    @Column
    var TITULO : String,
    @Column
    var EXTENSION : String,
)