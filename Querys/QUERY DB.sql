DROP DATABASE GRUPO1;
CREATE DATABASE GRUPO1;
USE GRUPO1;
-- CREATE TABLE VISUALIZACION_ONLINE (
--     ID_VISUALIZACION            INT NOT NULL
--     ,SISTEMA_OPERATIVO_USADO    VARCHAR(50)
--     ,FECHA_INICIO               DATE
--     ,FECHA_FIN                  DATE
--     ,HORA_INICIO                TIME
--     ,HORA_FIN                   TIME
--     ,PRIMARY KEY (ID_VISUALIZACION)
-- );

CREATE TABLE TIPO_CONTENIDO(
                               ID_TIPO_CONTENIDO           INT NOT NULL AUTO_INCREMENT
    ,DESCRIPCION                VARCHAR(255)
    ,PRIMARY KEY (ID_TIPO_CONTENIDO)
);

CREATE TABLE CONTENIDO (
                           ID_CONTENIDO                INT NOT NULL AUTO_INCREMENT
    ,TITULO                     VARCHAR(50)
    ,FECHA_PUBLICADO            DATETIME
    ,EXTENSION                  VARCHAR(4)
    ,URL                        VARCHAR(255)
    ,ID_TIPO_CONTENIDO          INT NOT NULL
    ,PRIMARY KEY (ID_CONTENIDO)
    ,FOREIGN KEY (ID_TIPO_CONTENIDO)
                               REFERENCES TIPO_CONTENIDO(ID_TIPO_CONTENIDO)
                               ON DELETE CASCADE
                               ON UPDATE CASCADE
);

-- CREATE TABLE VIDEO (
--     ID_CONTENIDO INT NOT NULL
--     ,TAMANIO     NUMERIC
--     ,PRIMARY KEY (ID_CONTENIDO)
--     ,FOREIGN KEY(ID_CONTENIDO)
--         REFERENCES CONTENIDO(ID_CONTENIDO)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
-- );

-- CREATE TABLE TIPO_DESCARGABLE(
--     ID_TIPO_DESCARGABLE          INT NOT NULL AUTO_INCREMENT
--     ,DESCRIPCION                VARCHAR(255)
--     ,PRIMARY KEY (ID_TIPO_DESCARGABLE)
-- );


-- CREATE TABLE DESCARGABLE (
--     ID_CONTENIDO INT NOT NULL
--     ,ID_TIPO_DESCARGABLE INT NOT NULL
--     ,PRIMARY KEY (ID_CONTENIDO)
--     ,FOREIGN KEY (ID_CONTENIDO)
--         REFERENCES CONTENIDO(ID_CONTENIDO)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
--     ,FOREIGN KEY (ID_TIPO_DESCARGABLE)
--         REFERENCES TIPO_DESCARGABLE(ID_TIPO_DESCARGABLE)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
-- );

-- CREATE TABLE MUSICA(
--     ID_CONTENIDO INT NOT NULL
--     ,CALIDAD     VARCHAR(50)
--     ,PRIMARY KEY (ID_CONTENIDO)
--     ,FOREIGN KEY (ID_CONTENIDO)
--         REFERENCES DESCARGABLE(ID_CONTENIDO)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
-- );

-- CREATE TABLE DOCUMENTO(
--     ID_CONTENIDO INT  UNIQUE
--     ,USA_PLANTILLA  BOOLEAN
--     ,PRIMARY KEY (ID_CONTENIDO)
--     ,FOREIGN KEY(ID_CONTENIDO)
--         REFERENCES DESCARGABLE(ID_CONTENIDO)
--         ON DELETE CASCADE
--         ON UPDATE CASCADE
-- );


CREATE TABLE USUARIO (
                         ID_USUARIO          INT NOT NULL AUTO_INCREMENT UNIQUE
    ,NOMBRE             VARCHAR(50)
    ,APELLIDO           VARCHAR(50)
    ,FECHA_NACIMIENTO   DATE
    ,CLAVE              VARCHAR(50)
    ,PRIMARY KEY (ID_USUARIO)

);

CREATE TABLE DESCARGA(
                         ID_DESCARGA     INT NOT NULL AUTO_INCREMENT
    ,VELOCIDAD_TRANSFERENCIA NUMERIC
    ,ID_USUARIO INT
    ,PRIMARY KEY(ID_DESCARGA)
    ,FOREIGN KEY (ID_USUARIO)
                             REFERENCES USUARIO(ID_USUARIO)
                             ON DELETE CASCADE
                             ON UPDATE CASCADE
);

CREATE TABLE CATEGORIA(
                          ID_CATEGORIA INT NOT NULL AUTO_INCREMENT
    ,TIPO        VARCHAR(50) NOT NULL
    ,PRIMARY KEY (ID_CATEGORIA)
);

CREATE TABLE COMENTARIO (
                            ID_COMENTARIO INT NOT NULL AUTO_INCREMENT
    ,TITULO         VARCHAR(50)
    ,DESCRIPCION    VARCHAR(50)
    ,APODO          VARCHAR(50)
    ,ID_CONTENIDO   INT NULL
    ,ID_USUARIO     INT NULL
    ,PRIMARY KEY (ID_COMENTARIO)
    ,FOREIGN KEY (ID_CONTENIDO)
                                REFERENCES CONTENIDO(ID_CONTENIDO)
                                on Delete CASCADE
                                on update cascade
    ,FOREIGN KEY (ID_USUARIO)
                                REFERENCES USUARIO(ID_USUARIO)
                                on delete cascade
                                on update cascade

);

CREATE TABLE REPLICA(
                        ID_REPLICA         INT AUTO_INCREMENT
    ,DETALLE            VARCHAR(50)
    ,APODO              VARCHAR(50)
    ,ID_POSEE_REPLICA   INT NULL
    ,ID_COMENTARIO      INT NULL
    ,PRIMARY KEY (ID_REPLICA)
    ,FOREIGN KEY (ID_POSEE_REPLICA)
                            REFERENCES REPLICA(ID_REPLICA)
                            ON DELETE CASCADE
                            ON UPDATE CASCADE
    ,FOREIGN KEY (ID_COMENTARIO)
                            REFERENCES COMENTARIO(ID_COMENTARIO)
                            ON DELETE CASCADE
                            ON UPDATE CASCADE
);

CREATE TABLE ES_REPRODUCIDO(
                               ID_USUARIO    INT NOT NULL
    ,ID_CONTENIDO       INT  NOT NULL
    ,FECHA_VISUALIZACION DATE NOT NULL
    ,PRIMARY KEY(ID_USUARIO,ID_CONTENIDO,FECHA_VISUALIZACION)
    ,FOREIGN KEY (ID_USUARIO)
                                   REFERENCES USUARIO(ID_USUARIO)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE
    ,FOREIGN KEY (ID_CONTENIDO)
                                   REFERENCES CONTENIDO(ID_CONTENIDO)
                                   on delete CASCADE
                                   ON UPDATE CASCADE

);



CREATE TABLE SE_CLASIFICA_EN(
                                ID_CONTENIDO    INT
    ,ID_CATEGORIA   INT
    ,PRIMARY KEY(ID_CONTENIDO,ID_CATEGORIA)
    ,FOREIGN KEY (ID_CONTENIDO)
                                    REFERENCES CONTENIDO(ID_CONTENIDO)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE
    ,FOREIGN KEY (ID_CATEGORIA)
                                    REFERENCES CATEGORIA(ID_CATEGORIA)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE

);


CREATE TABLE RTA_ENCUESTA(
                             ID_RTA_ENCUESTA                    INT AUTO_INCREMENT UNIQUE
    ,PUNTAJE_GLOBAL                     NUMERIC
    ,RESUMEN_POSITIVO_PLATAFORMA        VARCHAR(50)
    ,RESUMEN_NEGATIVO_PLATAFORMA        VARCHAR(50)
    ,RESUMEN_POSITIVO_DESCARGA          VARCHAR(50)
    ,RESUMEN_NEGATIVO_DESCARGA          VARCHAR(50)
    ,ID_DESCARGA                        INT NULL
    ,PRIMARY KEY (ID_RTA_ENCUESTA)
    ,FOREIGN KEY (ID_DESCARGA)
                                 REFERENCES DESCARGA(ID_DESCARGA)
                                 ON DELETE CASCADE
                                 ON UPDATE CASCADE

);

CREATE TABLE ES_DESCARGADO (
                               ID_CONTENIDO INT
    ,ID_DESCARGA INT
    ,PRIMARY KEY (ID_CONTENIDO,ID_DESCARGA)
    ,FOREIGN KEY (ID_CONTENIDO)
                                   REFERENCES CONTENIDO(ID_CONTENIDO)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE
    ,FOREIGN KEY (ID_DESCARGA)
                                   REFERENCES DESCARGA(ID_DESCARGA)
                                   ON DELETE CASCADE
                                   ON UPDATE CASCADE
);