package com.example.tpBD.controller

import com.example.tpBD.model.ContenidoG
import com.example.tpBD.repository.ContenidoGRepository
import com.example.tpBD.service.ContenidoGService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.server.MimeMappings
import org.springframework.util.MimeType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@CrossOrigin
class ContenidoGenController {
    @Autowired
    lateinit var contenidoGService : ContenidoGService
    @Autowired
    lateinit var contenidoRepository: ContenidoGRepository

    @GetMapping("/")
    fun hola() ="BUENAS"

    @GetMapping("/getAll")
    fun todosLosContenidos(): List<ContenidoG> {

        return contenidoGService.obtenerTodosLosContenidos()
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String? {
        contenidoGService.eliminarUnContenido(id) //
        return "Contenido eliminado"
    }

    @PostMapping("/guardarElContenido")
    fun guardarContenido(@RequestPart("contenidoG") contenidoG: ContenidoG, @RequestPart("archivo") archivo: MultipartFile): String {
        contenidoGService.guardarContenido(contenidoG, archivo.bytes)
        return "Contenido guardado"
    }

    @PutMapping("/actualizarContenido/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody contenidoG: ContenidoG): String? {
        contenidoGService.actualizarContenido(id, contenidoG)

        return "contenido actualizado"
    }

    @GetMapping("/obtenerContenidoPorID/{id}")
    fun buscarXID(@PathVariable id: Long): ContenidoG {
        return contenidoRepository.buscarContenidoPorId(id)
    }

    @GetMapping("/obtenerContenidosPorCategoria/{categoria}")
    fun buscarXCategoria(@PathVariable categoria: String): List<ContenidoG> {
        var categoriaNumber = 0
        when (categoria) {
            "Video" -> categoriaNumber = 1
            "Audio", "Documentos" -> categoriaNumber = 2
        }
        return contenidoGService.buscarPorCategoria(categoriaNumber)
    }
    @GetMapping("/contenidos-por-categoria")
    fun buscarPorCategorias(@RequestBody categorias: List<String>): List<ContenidoG> {
        return contenidoGService.buscarPorCategorias(categorias)
    }

}