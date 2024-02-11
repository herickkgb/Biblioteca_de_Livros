package com.herick.book.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herick.book.domain.Categoria;
import com.herick.book.dtos.CategoriaDTO;
import com.herick.book.exceptions.ObjectNotFoundExceptions;
import com.herick.book.service.CategoriaService;

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

}
