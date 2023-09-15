package com.exercicio.exercicioDesafio.service;

import com.exercicio.exercicioDesafio.dto.RecipesDTO;
import com.exercicio.exercicioDesafio.model.RecipesModel;
import com.exercicio.exercicioDesafio.repository.RecipesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipesService {

    @Autowired
    private RecipesRepository repository;

    //Ver todas as receitas
    public List<RecipesDTO> getAll(){
        List<RecipesModel> recipesModels = repository.findAll();
        List<RecipesDTO> recipesDTOS = new ArrayList<>();
        for (RecipesModel recipesModel : recipesModels){
            RecipesDTO recipesDTO = new RecipesDTO();
            BeanUtils.copyProperties(recipesModel, recipesDTO);
            recipesDTOS.add(recipesDTO);
        }
        return recipesDTOS;
    }

    //Adicionar nova receita
    public RecipesDTO save(RecipesDTO recipesDTO){
        RecipesModel recipesModel = new RecipesModel();
        BeanUtils.copyProperties(recipesDTO, recipesModel);
        repository.save(recipesModel);
        return recipesDTO;
    }

    //Atualizar dados da receita
    public RecipesDTO update(Long id, RecipesDTO recipesDTO){
        Optional<RecipesModel> recipesModelOptional = repository.findById(id);

        RecipesModel found = recipesModelOptional.get();
        if(recipesDTO.getImage() != null){
            found.setImage(recipesDTO.getImage());
        }
        if(recipesDTO.getTitle() != null){
            found.setImage(recipesDTO.getTitle());
        }
        if(recipesDTO.getIngredients() != null){
            found.setImage(recipesDTO.getIngredients());
        }
        if(recipesDTO.getSteps() != null){
            found.setImage(recipesDTO.getSteps());
        }
        repository.save(found);
        RecipesDTO newRecipesDTO = new RecipesDTO();
        BeanUtils.copyProperties(found, newRecipesDTO);
        return newRecipesDTO;
    }

    //Excluir uma receita
    public void delete(Long id){
        repository.deleteById(id);
    }
}
