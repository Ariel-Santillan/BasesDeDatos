package com.example.demo.Model;

import java.util.Date;
import javax.persistence.*;
//@Entity
//@Table(name="Contenido")

public abstract class Contenido {
    @Id
    Long id_contenido;
    String titulo;
    Date fecha_publicacion;

    String extension;
     public Contenido(Long id_contenido,String titulo,Date fecha_publicacion,String extension){
         this.id_contenido=id_contenido;
         this.titulo=titulo;
         this.fecha_publicacion=fecha_publicacion;
         this.extension=extension;
    }
    abstract void create (int idContenido, String titulo, Date fecha_publicacion, String extension);
    abstract void modify (int idContenido, String titulo, Date fecha_publicacion, String extension);
    abstract void delete (int idContenido, String titulo, Date fecha_publicacion, String extension);

}
class Descargable extends Contenido{
    public Descargable(Long id_contenido,String titulo,Date fecha_publicacion,String extension) {
        // uso del constructor de la clase abstracta
        super(id_contenido,titulo,fecha_publicacion,extension);
    }
    @Override
    public void create(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void modify(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void delete(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }
}
class Video extends Contenido {

    public Video(Long id_contenido,String titulo,Date fecha_publicacion,String extension) {
        // uso del constructor de la clase abstracta
        super(id_contenido,titulo,fecha_publicacion,extension);
    }

    @Override
    public void create(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void modify(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void delete(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }
}

class Documento extends Descargable {

    public Documento(Long id_contenido,String titulo,Date fecha_publicacion,String extension) {
        // uso del constructor de la clase abstracta
        super(id_contenido,titulo,fecha_publicacion,extension);
    }

    @Override
    public void create(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void modify(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void delete(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }
}

class Musica extends Descargable {

    public Musica(Long id_contenido,String titulo,Date fecha_publicacion,String extension) {
        // uso del constructor de la clase abstracta
        super(id_contenido,titulo,fecha_publicacion,extension);
    }

    @Override
    public void create(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void modify(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }

    @Override
    public void delete(int idContenido, String titulo, Date fecha_publicacion, String extension) {

    }
}

