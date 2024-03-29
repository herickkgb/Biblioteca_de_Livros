package com.herick.book.dtos;

import java.io.Serializable;

import com.herick.book.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 2720887060305930337L;

	private Long id;
	private String nome;
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria entity) {
		super();
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
