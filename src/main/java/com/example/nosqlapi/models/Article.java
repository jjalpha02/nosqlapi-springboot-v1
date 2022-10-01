package com.example.nosqlapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
public class Article {

	private Integer codeArticle;
	private String designation;
	private int quantite;
	private float prixunitaire;
    private Categorie categorie;


    public Article(Integer codeArticle, String designation, int quantite, float prixunitaire, Categorie categorie) {
        this.codeArticle = codeArticle;
        this.designation = designation;
        this.quantite = quantite;
        this.prixunitaire = prixunitaire;
        this.categorie = categorie;
    }

    public Article() {
    }

    public Integer getCodeArticle() {
        return this.codeArticle;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixunitaire() {
        return this.prixunitaire;
    }

    public void setPrixunitaire(float prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public void setCodeArticle(Integer codeArticle) {
        this.codeArticle = codeArticle;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "{" +
            " codeArticle='" + getCodeArticle() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", quantite='" + getQuantite() + "'" +
            ", prixunitaire='" + getPrixunitaire() + "'" +
            ", categorie='" + getCategorie() + "'" +
            "}";
    }


}
