package com.example.demo;

import java.util.Date;

abstract class Contenido {
    abstract void create (int idContenido, String titulo, Date fecha_publicacion, String extension);
    abstract void modify (int idContenido, String titulo, Date fecha_publicacion, String extension);
    abstract void delete (int idContenido, String titulo, Date fecha_publicacion, String extension);

}

class Documento extends Contenido {
    public (boolean usa_plantilla)

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

class Musica extends Contenido {
    public (String calidad)

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
    public (Float tamanio)

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