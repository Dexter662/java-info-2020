package com.informatorio.proyectoFinal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.informatorio.proyectoFinal.model.Post;
import com.informatorio.proyectoFinal.repository.PostRepository;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	//Mostrar todos los post
	public List<Post> listAllPost(){
		return postRepository.findAll();
	}
	
	//Crear post
	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	//Modificar post
	public Post get(Integer id) {
		return postRepository.findById(id).get();
	}
	
	//Eliminar post
	public void delete(Integer id) {
		postRepository.deleteById(id);
	}
	
}
