package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Descarga {

    @Id
    Long id_descarga;
    String Vel_transferencia;
}
