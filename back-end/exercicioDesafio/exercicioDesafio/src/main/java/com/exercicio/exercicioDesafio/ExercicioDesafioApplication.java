package com.exercicio.exercicioDesafio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Receitas API", version = "1", description = "Api para registro de receitas"))
public class ExercicioDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioDesafioApplication.class, args);
	}

}
