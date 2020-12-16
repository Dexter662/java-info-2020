package com.informatorio.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.informatorio.proyectoFinal.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
