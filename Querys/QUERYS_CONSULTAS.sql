--Se lista los contenidos que son documetnos
select cont.*,doc.USA_PLANTILLA
from documento doc
inner join contenido cont on cont.ID_CONTENIDO=doc.ID_CONTENIDO;

-- Busqueda contenido por Extension de archivo
select *
from contenido 
where EXTENSION in('MP4','PDF');


-- Busca contenidos por categoria
select distinct cont.*
from se_clasifica_en claf
inner join contenido cont on cont.ID_CONTENIDO = claf.ID_CONTENIDO
inner join categoria cat on cat.ID_CATEGORIA = claf.ID_CATEGORIA
where cat.TIPO in ('BASICO','ULTRA')
order by cont.ID_CONTENIDO desc;

-- Busca contenidos por titulo. 
SELECT *
FROM CONTENIDO 
WHERE TITULO LIKE '%N%';

-- Inserta un documento
INSERT  CONTENIDO (TITULO,FECHA_PUBLICADO,EXTENSION,URL) VALUES('AGREGACION DE CONTENIDO','2021-05-01','MP4','https://drive.google.com/drive/u/0/folders/AGREGACION DE CONTENIDO.MP4');

-- Lista de todos los contenidos. 
SELECT * FROM CONTENIDO;

-- Elimina un contenido 
DELETE FROM CONTENIDO
WHERE ID_CONTENIDO=51;

-- Cantidad de descargas por extension. 
SELECT CTN.EXTENSION, COUNT(ES_DESCARGADO.ID_CONTENIDO) CANTIDAD_ARCHIVOS_DESCARGADOS
FROM contenido CTN
RIGHT JOIN descargable DSC ON DSC.ID_CONTENIDO = CTN.ID_CONTENIDO
LEFT JOIN ES_DESCARGADO ON ES_DESCARGADO.ID_CONTENIDO = DSC.ID_CONTENIDO
GROUP BY CTN.EXTENSION
ORDER BY COUNT(ES_DESCARGADO.ID_CONTENIDO) DESC
;


-- Cantidad de videos vistos por extension
SELECT CTN.EXTENSION,COUNT(MIRA.ID_CONTENIDO) CANTIDAD_DE_VIDEOS_VISTOS
FROM contenido CTN
INNER JOIN VIDEO VD ON VD.ID_CONTENIDO = CTN.ID_CONTENIDO
INNER JOIN MIRA ON MIRA.ID_CONTENIDO = VD.ID_CONTENIDO
GROUP BY CTN.EXTENSION
ORDER BY COUNT(MIRA.ID_CONTENIDO) DESC ;


-- Cantidad de veces que se descargo un archivo
--Ordenar archivos (no importa su tipo o categoría) por cantidad de descargas de mayor a menor
SELECT CTN.*, COUNT(ES_DESCARGADO.ID_CONTENIDO) CANTIDAD_ARCHIVOS_DESCARGADOS
FROM contenido CTN
RIGHT JOIN descargable DSC ON DSC.ID_CONTENIDO = CTN.ID_CONTENIDO
LEFT JOIN ES_DESCARGADO ON ES_DESCARGADO.ID_CONTENIDO = DSC.ID_CONTENIDO
GROUP BY CTN.ID_CONTENIDO
ORDER BY COUNT(ES_DESCARGADO.ID_CONTENIDO) DESC;



-- Cantidad de veces que se vio un video
SELECT CTN.*,COUNT(MIRA.ID_CONTENIDO) CANTIDAD_DE_VIDEOS_VISTOS
FROM contenido CTN
INNER JOIN VIDEO VD ON VD.ID_CONTENIDO = CTN.ID_CONTENIDO
INNER JOIN MIRA ON MIRA.ID_CONTENIDO = VD.ID_CONTENIDO
GROUP BY CTN.ID_CONTENIDO
ORDER BY COUNT(MIRA.ID_CONTENIDO) DESC;


-- Busca contenidos por categoria de forma excluyente, es decir que debe tener todas las categorias seleccionadas.
select cont.*
from se_clasifica_en claf
inner join contenido cont on cont.ID_CONTENIDO = claf.ID_CONTENIDO
inner join categoria cat on cat.ID_CATEGORIA = claf.ID_CATEGORIA
where cat.TIPO in ('BASICO','ULTRA')
group by cont.ID_CONTENIDO 
having count(distinct cat.tipo) = 2;


-- Filtrar todos los contenidos cuya fecha de publicación esté dentro de un rango a elección del usuario logueado.
SELECT *
FROM CONTENIDO CONT 
WHERE FECHA_PUBLICADO BETWEEN '2022-01-01' AND '2022-12-31';