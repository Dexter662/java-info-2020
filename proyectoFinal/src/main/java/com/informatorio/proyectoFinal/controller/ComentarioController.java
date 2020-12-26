package com.informatorio.proyectoFinal.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.informatorio.proyectoFinal.model.Comentario;
import com.informatorio.proyectoFinal.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
	
	@Autowired
	ComentarioService comentarioService;
	
	//Mostrar comentarios
	@GetMapping("")
    public List<Comentario> list() {
        return comentarioService.listAllComentario();
    }
	
	//Detalle comentario especifico
	@GetMapping("detalle/{id}")
    public ResponseEntity<Comentario> get(@PathVariable Integer id) {
        try {
        	Comentario comentario = comentarioService.get(id);
            return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Comentario>(HttpStatus.NOT_FOUND);
        }
    }
	
	//Crear comentario
	@PostMapping("nuevo")
	public ResponseEntity<Comentario> add(@RequestBody Comentario comentario){
		return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.save(comentario));
	}
	
	//Modificar comentario
	@PutMapping("editar/{id}")
	public Comentario update(Comentario comentario, @PathVariable Integer id) {
        return null;
    }
	
	//Eliminar comentario
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Integer id) {

        comentarioService.delete(id);
    }
}
