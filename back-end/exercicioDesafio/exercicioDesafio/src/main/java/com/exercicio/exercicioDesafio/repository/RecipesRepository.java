package com.exercicio.exercicioDesafio.repository;

import com.exercicio.exercicioDesafio.model.RecipesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends JpaRepository<RecipesModel, Long> {
}
