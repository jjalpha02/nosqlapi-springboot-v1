package com.example.nosqlapi.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategorieDTO {
    
    private Integer idCateg;
	private String libelle;
	private List<ArticleDTO> articles;

}
