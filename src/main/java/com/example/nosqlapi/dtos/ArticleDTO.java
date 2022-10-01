package com.example.nosqlapi.dtos;

import com.example.nosqlapi.models.Categorie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDTO {

    private Integer codeArticle;
	private String designation;
	private int quantite;
	private float prixunitaire;
	private Categorie categorie;

}
