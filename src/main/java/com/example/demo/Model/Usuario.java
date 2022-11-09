package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    Long id_usuario;

    @Column
    String nombre;

    @Column
    String apellido;

    @Column
    Date fecha_nac;

    @Column
    String clave;

}
