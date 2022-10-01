package com.example.nosqlapi.controllers;

import java.util.List;

import com.example.nosqlapi.dtos.ArticleDTO;
import com.example.nosqlapi.models.Article;
import com.example.nosqlapi.models.Categorie;
import com.example.nosqlapi.services.ArticleService;
import com.example.nosqlapi.services.CategorieService;
import com.google.common.reflect.TypeToken;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    
    @Autowired
    ArticleService articleService;

    @Autowired
    CategorieService categorieService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<ArticleDTO> getAll(){
        List<Article> articles = articleService.getAll();
        TypeToken<List<ArticleDTO>> typeToken = new TypeToken<List<ArticleDTO>>(ArticleDTO.class) {};
        return modelMapper.map(articles, typeToken.getType());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createArticle(@RequestBody ArticleDTO articleDTO){

        articleService.createArticle(modelMapper.map(articleDTO, Article.class));
        Categorie categorie = modelMapper.map(articleDTO, Article.class).getCategorie();

        categorie = categorieService.getByIdCategAndLibelle(categorie.getIdCateg(), categorie.getLibelle());
        categorie.getArticles().add(modelMapper.map(articleDTO, Article.class));

        return new ResponseEntity<>("Article crée avec succees", HttpStatus.OK);
    }

    @GetMapping(value = "/by_id/{code_article}")
    public ArticleDTO getOne(@PathVariable("code_article") Integer id){
        Article article = articleService.getOne(id);
        return modelMapper.map(article, ArticleDTO.class);
    }

    @DeleteMapping(value = "/delete/{code_article}")
    public ResponseEntity<?> deleteArticle(@PathVariable("code_article") Integer id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>("Suppression effectué avec succès", HttpStatus.OK);
    }




}
