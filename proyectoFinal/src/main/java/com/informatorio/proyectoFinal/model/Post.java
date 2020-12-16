package com.informatorio.proyectoFinal.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String titulo;
	private String descripcion;
	private String contenido;
	private Date fecha_creacion;
	private Boolean publicado;
	
	@JoinColumn(name = "AUTOR", nullable = false)
    @ManyToOne
    private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	private List<Comentario> comentarios;
	
	public Post(){
		
	}
	
	public Post(int id, String titulo, String descripcion, String contenido, Date fecha_creacion, Boolean publicado) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.fecha_creacion = fecha_creacion;
		this.publicado = publicado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getComentarios() {
		return comentarios == null ? null : new ArrayList<>(comentarios);
	}

	public void setComentarios(List<Comentario> comentarios) {
		if (comentarios == null) {
			this.comentarios = null;
		} else {
			this.comentarios = Collections.unmodifiableList(comentarios);
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaCreacion() {
		return fecha_creacion;
	}

	public void setFechaCreacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Boolean getPublicado() {
		return publicado;
	}

	public void setPublicado(Boolean publicado) {
		this.publicado = publicado;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}

