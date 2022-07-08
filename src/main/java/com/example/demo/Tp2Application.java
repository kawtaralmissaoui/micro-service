package com.example.demo;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Tp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp2Application.class, args);
	}

	@Bean
	CommandLineRunner start(ProduitRepository produitRepository){
		return args->{
			produitRepository.save(new Product(null,"Telephone",98000,true));
			produitRepository.save(new Product(null,"Television",2500,false));
			produitRepository.save(new Product(null,"stylos",800,true));
			produitRepository.findAll().forEach(cp->{
				System.out.println(cp.getName());
				System.out.println(cp.getPrice());
				System.out.println(cp.getPromotion());
			});

		};
	}
}
