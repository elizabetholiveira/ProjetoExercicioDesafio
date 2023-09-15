package com.exercicio.exercicioDesafio.dto;

import com.exercicio.exercicioDesafio.model.RecipesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipesDTO {

    //private Long id;

    private String image;

    private String title;

    private String ingredients;

    private String steps;

}
