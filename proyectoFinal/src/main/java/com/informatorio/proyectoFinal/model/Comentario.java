package com.informatorio.proyectoFinal.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	private Date fecha_creacion;
	private String comentario;
	
	@JoinColumn(name = "AUTOR", nullable = false)
    @ManyToOne
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "FK_POST", nullable = false)
    private Post post;
	
	public Comentario() {
		
	}
	
	public Comentario(int id, Date fecha_creacion, String comentario) {
		this.id = id;
		this.fecha_creacion = fecha_creacion;
		this.comentario = comentario;
	}

	public Date getFechaCreacion() {
		return fecha_creacion;
	}

	public void setFechaCreacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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
