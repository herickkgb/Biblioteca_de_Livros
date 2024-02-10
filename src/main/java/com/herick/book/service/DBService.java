package com.herick.book.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herick.book.domain.Categoria;
import com.herick.book.domain.Livro;
import com.herick.book.repositories.CategoriaRepository;
import com.herick.book.repositories.LivrosRepository;

@Service
public class DBService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivrosRepository livrosRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Desenvolvimento", "Livros de Desenvolvimento de Software");
		Categoria cat3 = new Categoria(null, "Redes", "Livros de Redes de Computadores");
		Categoria cat4 = new Categoria(null, "Banco de Dados", "Livros de Banco de Dados");
		Categoria cat5 = new Categoria(null, "Seguranca", "Livros de Seguranca da Informacao");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsun", cat1);
		Livro l2 = new Livro(null, "Refactoring", "Martin Fowler", "Some content", cat2);
		Livro l3 = new Livro(null, "Network Security Essentials", "William Stallings", "More content", cat3);
		Livro l4 = new Livro(null, "Database Management Systems", "Raghu Ramakrishnan", "Another content", cat4);
		Livro l5 = new Livro(null, "Hacking: The Art of Exploitation", "Jon Erickson", "Content here", cat5);

		cat1.getLivros().add(l1);
		cat2.getLivros().add(l2);
		cat3.getLivros().add(l3);
		cat4.getLivros().add(l4);
		cat5.getLivros().add(l5);

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		this.livrosRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
