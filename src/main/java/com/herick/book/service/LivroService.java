package com.herick.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herick.book.domain.Livro;
import com.herick.book.repositories.LivrosRepository;

@Service
public class LivroService {
	@Autowired
	private LivrosRepository repository;

	@Transactional(readOnly = true)
	public Optional<Livro> findById(Long id) {
		return repository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Livro> findAll() {
		return repository.findAll();
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	public Livro create(Livro livro) {
		return repository.save(livro);
	}

	@Transactional
	public Livro update(Long id, Livro entity) {
		Livro livroSearch = repository.getOne(id);
	//	livroSearch.setId(entity.getId());
		livroSearch.setNomeAutor(entity.getNomeAutor());
		livroSearch.setTexto(entity.getTexto());
		livroSearch.setTitulo(entity.getTitulo());
		return repository.save(livroSearch);
	}

}
