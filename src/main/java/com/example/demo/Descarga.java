package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Descarga {

    @Id
    Long id_descarga;
    String Vel_transferencia;
}
