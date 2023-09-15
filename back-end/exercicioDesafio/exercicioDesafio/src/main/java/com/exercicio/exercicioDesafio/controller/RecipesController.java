package com.exercicio.exercicioDesafio.controller;

import com.exercicio.exercicioDesafio.dto.RecipesDTO;
import com.exercicio.exercicioDesafio.model.RecipesModel;
import com.exercicio.exercicioDesafio.repository.RecipesRepository;
import com.exercicio.exercicioDesafio.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recipes")
public class RecipesController {

    @Autowired
    RecipesService service;

    @Autowired
    RecipesRepository repository;

    //GET
    @GetMapping
    public ResponseEntity<List<RecipesDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    //POST
    @PostMapping
    public ResponseEntity<RecipesDTO> save(@RequestBody RecipesDTO recipesDTO){
        RecipesDTO newRecipe = service.save(recipesDTO);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping(path = "/{id}")
    public ResponseEntity<RecipesDTO> update(@PathVariable Long id, @RequestBody RecipesDTO recipesDTO){
        RecipesDTO updatedRecipe = service.update(id, recipesDTO);
        return ResponseEntity.ok(updatedRecipe);
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
