package com.example.nosqlapi.services;

import java.util.List;

import com.example.nosqlapi.models.Article;

public interface ArticleService {
    
    public List<Article> getAll();

    public Article getOne(Integer id);

    public Article createArticle(Article article);

    public Article updateArticle(Article article);

    public void deleteArticle(Integer id);
    
}
