package com.herick.book.dtos;

import java.io.Serializable;

import com.herick.book.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = -4403760046354546434L;

	private Long id;
	private String titulo;
	private String nomeAutor;
	private String texto;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Long id, String titulo, String nomeAutor, String texto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
	}

	public LivroDTO(Livro entity) {
		super();
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.nomeAutor = entity.getNomeAutor();
		this.texto = entity.getTexto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LivroDTO(Long id) {
		super();
		this.id = id;
	}

}
