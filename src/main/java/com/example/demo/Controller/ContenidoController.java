package com.example.demo.Controller;


import com.example.demo.Service.ContenidoService;
import com.example.demo.Model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:4200/"})
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping("/getAll")
    public List<Contenido> getAll(){
        return contenidoService.encontrarTodos();

    }
}
