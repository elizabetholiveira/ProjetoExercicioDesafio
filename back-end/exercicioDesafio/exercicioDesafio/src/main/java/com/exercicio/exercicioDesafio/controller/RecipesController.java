package com.exercicio.exercicioDesafio.controller;

import com.exercicio.exercicioDesafio.dto.RecipesDTO;
import com.exercicio.exercicioDesafio.repository.RecipesRepository;
import com.exercicio.exercicioDesafio.service.RecipesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recipes")
@Tag(name = "Receitas")
public class RecipesController {

    @Autowired
    RecipesService service;

    @Autowired
    RecipesRepository repository;

    //GET
    @GetMapping
    @Operation(summary = "Lista todas as receitas", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Listagem realizada com sucesso"))
    public ResponseEntity<List<RecipesDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    //POST
    @PostMapping
    @Operation(summary = "Adiciona uma receita nova no banco", method = "POST")
    @ApiResponses(value = @ApiResponse(responseCode = "201", description = "Criação de receita feita com sucesso"))
    public ResponseEntity<RecipesDTO> save(@RequestBody RecipesDTO recipesDTO){
        RecipesDTO newRecipe = service.save(recipesDTO);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping(path = "/{id}")
    @Operation(summary = "Altera os dados de uma receita", method = "PUT")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Atualização feita com sucesso"))
    public ResponseEntity<RecipesDTO> update(@PathVariable Long id, @RequestBody RecipesDTO recipesDTO){
        RecipesDTO updatedRecipe = service.update(id, recipesDTO);
        return ResponseEntity.ok(updatedRecipe);
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Deleta uma receita pelo ID", method = "DELETE")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Exclusão feita com sucesso"))
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
