package com.example.demo;

import com.example.demo.entities.Compte;
import com.example.demo.enums.TypeCompte;
import com.example.demo.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Application.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository){
		return args->{
			compteRepository.save(new Compte(null,98000,new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null,1234,new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null,5000,new Date(), TypeCompte.COURANT));
			compteRepository.findAll().forEach(cp->{
				System.out.println(cp.getType());
				System.out.println(cp.getSolde());
			});

		};
	}
}
