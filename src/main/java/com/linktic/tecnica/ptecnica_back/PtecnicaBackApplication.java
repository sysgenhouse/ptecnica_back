package com.linktic.tecnica.ptecnica_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.linktic.tecnica.ptecnica_back.Repositories")
public class PtecnicaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtecnicaBackApplication.class, args);
	}

}
