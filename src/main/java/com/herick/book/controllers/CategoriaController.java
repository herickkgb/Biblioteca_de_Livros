package com.herick.book.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herick.book.domain.Categoria;
import com.herick.book.dtos.CategoriaDTO;
import com.herick.book.exceptions.ObjectNotFoundExceptions;
import com.herick.book.service.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService service;

	@GetMapping
	private ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> dto = list.stream().map(CategoriaDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/{id}")
	private Categoria findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ObjectNotFoundExceptions("Recusro não encontrado para o ID: " + id));
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
		categoria = service.create(categoria);
		URI location = buildLocationUri(categoria.getId());
		return ResponseEntity.created(location).build();
	}

	@PatchMapping(value = "/{id}")
	private ResponseEntity<CategoriaDTO> update(@PathVariable Long id,@Valid @RequestBody CategoriaDTO entity) {
		Categoria cat = service.update(id, entity);
		URI location = buildLocationUri(cat.getId());
		return ResponseEntity.created(location).body(new CategoriaDTO(cat));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	private URI buildLocationUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
}
