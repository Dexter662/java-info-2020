package com.informatorio.proyectoFinal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.informatorio.proyectoFinal.model.Usuario;
import com.informatorio.proyectoFinal.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Mostrar todos los usuarios
	public List<Usuario> listAllUsuario(){
		return usuarioRepository.findAll();
	}
	
	//Crear usuario
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	//Modificar usuario
	public Usuario get(Integer id) {
		return usuarioRepository.findById(id).get();
	}
	
	//Eliminar usuario
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}

}
