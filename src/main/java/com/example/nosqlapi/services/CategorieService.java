package com.example.nosqlapi.services;

import java.util.List;

import com.example.nosqlapi.models.Categorie;

public interface CategorieService {

    public List<Categorie> getAll();

    public Categorie getOne(Integer id);

    public Categorie getByIdCategAndLibelle(Integer id, String libelle);

    public Categorie createCategorie(Categorie categorie);

    public Categorie updateCategorie(Categorie categorie);

    public void deleteCategorie(Integer id);
    
}
