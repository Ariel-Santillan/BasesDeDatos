package com.example.demo.Repository;

import com.example.demo.Model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {

    @Query(value = "Select c.id_contenido from Contenido as c") //, nativeQuery = true
    List<Contenido> encontrarTodos();

}

