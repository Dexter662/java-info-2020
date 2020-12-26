package com.informatorio.proyectoFinal.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	private LocalDate fechaCreacion = LocalDate.now();
	private String comentario;
	
	@JoinColumn(name = "AUTOR", nullable = false)
    @ManyToOne
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "FK_POST", nullable = false)
    private Post post;
	
	public Comentario() {
		
	}
	
	public Comentario(int id, LocalDate fechaCreacion, String comentario) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.comentario = comentario;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
