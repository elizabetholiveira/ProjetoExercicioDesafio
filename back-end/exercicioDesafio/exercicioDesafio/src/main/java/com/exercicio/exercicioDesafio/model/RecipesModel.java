package com.exercicio.exercicioDesafio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "TB_RECIPES")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String ingredients;

    @Column(nullable = false)
    private String steps;
}
