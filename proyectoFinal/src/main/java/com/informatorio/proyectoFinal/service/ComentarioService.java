package com.informatorio.proyectoFinal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.informatorio.proyectoFinal.model.Comentario;
import com.informatorio.proyectoFinal.repository.ComentarioRepository;
import com.informatorio.proyectoFinal.repository.UsuarioRepository;

@Service
@Transactional
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	//Mostrar todos los comentario
	public List<Comentario> listAllComentario(){
		return comentarioRepository.findAll();
	}
	
	//Crear comentario
	public Comentario save(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	//Modificar comentario
	public Comentario get(Integer id) {
		return comentarioRepository.findById(id).get();
	}
	
	//Eliminar comentario
	public void delete(Integer id) {
		comentarioRepository.deleteById(id);
	}
	
}
