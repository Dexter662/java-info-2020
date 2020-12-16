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
import com.informatorio.proyectoFinal.model.Usuario;
import com.informatorio.proyectoFinal.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	//Mostrar Usuarios
	@GetMapping("")
    public List<Usuario> list() {
        return usuarioService.listAllUsuario();
    }
	
	//Detalle Usuario especifico
	@GetMapping("detalle/{id}")
    public ResponseEntity<Usuario> get(@PathVariable Integer id) {
        try {
        	Usuario usuario = usuarioService.get(id);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
	
	//Crear Usuario
	@PostMapping("nuevo")
    public void add(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }
	
	//Modificar Usuario
	@PutMapping("editar/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Usuario usuario, @PathVariable Integer id) {
        try {
        	Usuario existeUsuario = usuarioService.get(id);
        	usuario.setId(id);            
        	usuarioService.save(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	//Eliminar Usuario
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable Integer id) {

        usuarioService.delete(id);
    }
	
}
