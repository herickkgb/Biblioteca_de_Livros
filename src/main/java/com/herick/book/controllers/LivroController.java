package com.herick.book.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herick.book.domain.Livro;
import com.herick.book.dtos.LivroDTO;
import com.herick.book.exceptions.ObjectNotFoundExceptions;
import com.herick.book.service.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping
	public ResponseEntity<List<Livro>> findAll() {
		List<Livro> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public Livro findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ObjectNotFoundExceptions("Recurso não encontrado para o ID: " + id));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<LivroDTO> create(@Valid @RequestBody Livro entity) {
		Livro livro = service.create(entity);
		URI location = buildLocationUri(livro.getId());
		return ResponseEntity.created(location).body(new LivroDTO(livro));
	}

	@PostMapping("/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Long id, @Valid @RequestBody Livro entity) {
		Livro livro = service.update(id, entity);
		URI location = buildLocationUri(livro.getId());
		return ResponseEntity.created(location).body(new LivroDTO(livro));
	}

	private URI buildLocationUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
