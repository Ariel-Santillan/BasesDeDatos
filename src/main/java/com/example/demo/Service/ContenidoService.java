package com.example.demo.Service;

import com.example.demo.Repository.ContenidoRepository;
import com.example.demo.Model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoService {

    @Autowired
    ContenidoRepository contenidoRepository;

    public List<Contenido> encontrarTodos() {
        return contenidoRepository.encontrarTodos();
    }
}
