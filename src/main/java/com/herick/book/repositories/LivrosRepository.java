package com.herick.book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.herick.book.domain.Categoria;
import com.herick.book.domain.Livro;

@Repository
public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
