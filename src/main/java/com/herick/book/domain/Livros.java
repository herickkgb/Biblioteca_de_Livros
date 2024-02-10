package com.herick.book.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "livro")
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String tirulo;
	@NotNull
	@Column(name = "nome_autor")
	private String nomeAutor;
	@NotNull
	private String texto;
	@OneToMany
	private Categorias categorias;

	public Livros(Long id, @NotNull String tirulo, @NotNull String nomeAutor, @NotNull String texto) {
		super();
		this.id = id;
		this.tirulo = tirulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
	}

	public Livros() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTirulo() {
		return tirulo;
	}

	public void setTirulo(String tirulo) {
		this.tirulo = tirulo;
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

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livros other = (Livros) obj;
		return Objects.equals(id, other.id);
	}

}
