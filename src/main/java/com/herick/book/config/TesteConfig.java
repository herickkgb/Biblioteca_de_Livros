package com.herick.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.herick.book.service.DBService;

@Configuration
@Profile("teste")
public class TesteConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public void instanciaBaseDeDados() {
		dbService.instanciaBaseDeDados();
	}
}
