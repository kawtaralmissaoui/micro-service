package com.example.demo.web;

import com.example.demo.entities.Compte;
import com.example.demo.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComptesRestController {

    private CompteRepository compteRepository;

    public ComptesRestController(CompteRepository compteRepository){
        this.compteRepository=compteRepository;
    }
@GetMapping(path="/comptes")
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    }

    @GetMapping(path="/comptes/{id}")
    public Compte getCompte(@PathVariable(name="id") Long code){
        return compteRepository.findById(code).get();
    }

    @PostMapping(path="/comptes")
    public Compte save(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping(path="/comptes/{code}")
    public Compte update(@PathVariable Long code ,@RequestBody Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path="/comptes/{code}")
    public void delete(@PathVariable Long code ){
         compteRepository.deleteById(code);
    }


}
