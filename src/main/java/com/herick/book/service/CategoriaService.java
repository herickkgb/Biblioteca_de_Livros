package com.herick.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herick.book.domain.Categoria;
import com.herick.book.dtos.CategoriaDTO;
import com.herick.book.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;

	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Categoria> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Categoria create(Categoria entity) {
		return repository.save(entity);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	public Categoria update(Long id, CategoriaDTO entity) {
		Categoria cat = repository.getOne(id);
		cat.setNome(entity.getNome());
		cat.setDescricao(entity.getDescricao());
		return repository.save(cat);
	}

}
