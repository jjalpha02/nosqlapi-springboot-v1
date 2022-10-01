package com.example.nosqlapi.repositories;

import com.example.nosqlapi.models.Categorie;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieRepository extends MongoRepository<Categorie, String> {

    public Categorie findByIdCateg(Integer Id);

    public void deleteByIdCateg(Integer Id);

    public Categorie findByIdCategAndLibelle(Integer Id, String libelle);
}
