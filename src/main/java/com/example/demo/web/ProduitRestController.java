package com.example.demo.web;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestController {

    private ProduitRepository produitRepository;

    public ProduitRestController(ProduitRepository produitRepository){
        this.produitRepository=produitRepository;
    }
    @GetMapping(path="/produits")
    public List<Product> listCProduits(){
        return produitRepository.findAll();
    }

    @GetMapping(path="/produits/{id}")
    public Product getProduit(@PathVariable(name="id") Long code){
        return produitRepository.findById(code).get();
    }

    @PostMapping(path="/produits")
    public Product save(@RequestBody Product produit){
        return produitRepository.save(produit);
    }

    @DeleteMapping(path="/produits/{id}")
    public void delete(@PathVariable Long id ){
        produitRepository.deleteById(id);
    }

    @PutMapping(path="/produits/{id}")
    public Product update(@PathVariable Long code ,@RequestBody Product product){
        product.setId(code);
        return produitRepository.save(product);
    }


}
