package com.informatorio.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.informatorio.proyectoFinal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
}
