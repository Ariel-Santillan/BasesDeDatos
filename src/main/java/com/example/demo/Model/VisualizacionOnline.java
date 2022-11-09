package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class VisualizacionOnline {
    @Id
    @GeneratedValue
    Long id_visualizacion;

    @Column
    String soUsado;

    @Column
    Date fecha_inicio;

    @Column
    Date fecha_fin;

    @Column
    Date hora_inicio;

    @Column
    Date hora_fin;


}
