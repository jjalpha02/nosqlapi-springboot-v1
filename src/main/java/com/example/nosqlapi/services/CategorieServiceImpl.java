package com.example.nosqlapi.services;

import java.util.List;

import com.example.nosqlapi.models.Categorie;
import com.example.nosqlapi.repositories.CategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie getOne(Integer id){
        return categorieRepository.findByIdCateg(id);
    }

    @Override
    public Categorie getByIdCategAndLibelle(Integer id, String libelle) {
        return categorieRepository.findByIdCategAndLibelle(id, libelle);
    }

    @Override
    public Categorie createCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAll(){
        return categorieRepository.findAll();
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Integer id) {
        categorieRepository.deleteByIdCateg(id);        
    }


}
