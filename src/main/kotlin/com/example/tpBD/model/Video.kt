package com.example.tpBD.model

import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.ManyToMany

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
class Video : Contenido() {

    @ManyToMany(mappedBy = "mirado")
    val miradoPor : List<Visualizacion_Online> = listOf()

}