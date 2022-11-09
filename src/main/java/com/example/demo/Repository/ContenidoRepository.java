package com.example.demo.Repository;

import com.example.demo.Model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {

    @Query(value = "Select c from Contenido c", nativeQuery = true) //, nativeQuery = true
    List<Contenido> getContenidos();

    @Query(value = "delete from Contenido c where c.id_contenido= :id")
    void deleteContenidoByID(@Param("id") Long id);
}

