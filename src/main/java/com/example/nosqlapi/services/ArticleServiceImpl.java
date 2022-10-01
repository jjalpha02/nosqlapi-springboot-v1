package com.example.nosqlapi.services;

import java.util.List;

import com.example.nosqlapi.models.Article;
import com.example.nosqlapi.repositories.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired 
    public ArticleRepository articleRepository;

    public List<Article> getAll(){
        return articleRepository.findAll();
    }

    public Article getOne(Integer id){
        return articleRepository.findByCodeArticle(id);
    }

    public Article createArticle(Article article){
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article){
        return null;
    }

    public void deleteArticle(Integer id){
         articleRepository.deleteByCodeArticle(id);
    }
}
