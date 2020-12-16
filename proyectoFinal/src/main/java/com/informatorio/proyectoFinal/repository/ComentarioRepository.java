package com.informatorio.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.proyectoFinal.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

}
