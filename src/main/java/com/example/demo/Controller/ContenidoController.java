package com.example.demo.Controller;


import com.example.demo.Service.ContenidoService;
import com.example.demo.Model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins={"http://localhost:4200/"})
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping("/getContenido")
    public List<Contenido> getContenidos(){
        return contenidoService.getContenidos();
    }

    @DeleteMapping("/deleteContenidoByID/{id}")
    public void borrarAcercaDe(@PathVariable Long id) { contenidoService.deleteContenidoByID(id); }

}
