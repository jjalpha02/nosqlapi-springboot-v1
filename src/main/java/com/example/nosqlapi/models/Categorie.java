package com.example.nosqlapi.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "categories")
public class Categorie {

    private Integer idCateg;
	private String libelle;
	private List<Article> articles = new ArrayList<>();


    public Categorie(Integer idCateg, String libelle, List<Article> articles) {
        this.idCateg = idCateg;
        this.libelle = libelle;
        this.articles = articles == null ? new ArrayList<>(): articles;
    }

    public Categorie() {
    }

    public Integer getIdCateg() {
        return this.idCateg;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setIdCateg(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "idCateg=" + idCateg +
                ", libelle='" + libelle + '\'' +
                ", articles=" + articles +
                '}';
    }
}
