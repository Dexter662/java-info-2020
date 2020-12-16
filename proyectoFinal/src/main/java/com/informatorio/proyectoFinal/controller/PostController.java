package com.informatorio.proyectoFinal.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informatorio.proyectoFinal.model.Comentario;
import com.informatorio.proyectoFinal.model.Post;
import com.informatorio.proyectoFinal.model.Usuario;
import com.informatorio.proyectoFinal.service.PostService;


@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	//Mostrar posts
	@GetMapping("")
    public List<Post> list() {
        return postService.listAllPost();
    }
	
	//Detalle post especifico
	@GetMapping("detalle/{id}")
    public ResponseEntity<Post> get(@PathVariable Integer id) {
        try {
        	Post post = postService.get(id);
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
    }
	
	//Crear post
	@PostMapping("nuevo")
	public ResponseEntity<Post> add(@RequestBody Post post){
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
	}
	
	//Modificar post
	@PutMapping("editar/{id}")
	public ResponseEntity<Post> update(@Validated @RequestBody Post post, @PathVariable Integer id) {
		Post existePost = postService.get(id);
        post.setId(id);            
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));

    }
	
	//Eliminar post
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Integer id) {

        postService.delete(id);
    }
}
