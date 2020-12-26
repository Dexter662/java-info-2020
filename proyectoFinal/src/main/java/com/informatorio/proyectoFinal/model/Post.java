package com.informatorio.proyectoFinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	private LocalDate fechaCreacion = LocalDate.now();
	private Boolean publicado;
	
	@JoinColumn(name = "AUTOR", nullable = false)
    @ManyToOne
    private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	private List<Comentario> comentarios;
	
	public Post(){
		
	}
	
	public Post(int id, String titulo, String descripcion, String contenido, LocalDate fechaCreacion, Boolean publicado) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.fechaCreacion = fechaCreacion;
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

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

