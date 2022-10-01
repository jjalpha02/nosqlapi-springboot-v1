package com.example.nosqlapi.repositories;

import com.example.nosqlapi.models.Article;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {

    public Article findByCodeArticle(Integer id);

    public void deleteByCodeArticle(Integer id);
    
}
