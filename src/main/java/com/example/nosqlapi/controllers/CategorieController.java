package com.example.nosqlapi.controllers;

import java.util.List;

import com.example.nosqlapi.dtos.CategorieDTO;
import com.example.nosqlapi.models.Categorie;
import com.example.nosqlapi.repositories.CategorieRepository;
import com.example.nosqlapi.services.CategorieService;
import com.google.common.reflect.TypeToken;

import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
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
@RequestMapping("/categories")
public class CategorieController {
    
    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategorieRepository categorieRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CategorieDTO> getAll(){
        List <Categorie> categories = categorieService.getAll();
        TypeToken<List<CategorieDTO>> typeToken = new TypeToken<List<CategorieDTO>>(CategorieDTO.class){};
        return modelMapper.map(categories, typeToken.getType());
    } 

    @PostMapping(value= "/create")
    public ResponseEntity<?> createCategorie(@RequestBody CategorieDTO categorieDTO){
        categorieService.createCategorie(modelMapper.map(categorieDTO, Categorie.class));
        return new ResponseEntity<>("Enregistrement effectué avec succès", HttpStatus.OK);
    } 

/*     @PostMapping(value= "/create")
    public ResponseEntity<?> createCategorie(@RequestBody Categorie categorie){
        categorieRepository.save(categorie);
        return new ResponseEntity<>("Enregistrement effectué avec succès", HttpStatus.OK);
    } */

    @GetMapping(value="/by_id/{idcateg}")
    public CategorieDTO getOne(@PathVariable("idcateg") Integer id){
        Categorie categorie = categorieService.getOne(id);
        return modelMapper.map(categorie, CategorieDTO.class);
    }

    @DeleteMapping(value = "/delete/{id_categ}")
    public ResponseEntity<?> deleteCategorie(@PathVariable("id_categ") Integer id){
        categorieService.deleteCategorie(id);
        return new ResponseEntity<>("Suppression effectué avec succes", HttpStatus.OK);
    }

}
