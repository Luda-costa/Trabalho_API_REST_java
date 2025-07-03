package com.example.crud_user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crud_user.model.ContaBancaria;
import com.example.crud_user.repository.ContaBancariaRepository;

@SpringBootApplication
public class CrudContaBancariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudContaBancariaApplication.class, args);
	}

	@Bean
	public CommandLineRunner inserirContas(final ContaBancariaRepository repository){
		return (args) ->{
			repository.save(new ContaBancaria("12345-6", "Fulano", true));
			repository.save(new ContaBancaria("22364-2", "Jorge", true ));
			repository.save(new ContaBancaria("36275-5", "Bento", true));
			repository.save(new ContaBancaria("43693-8", "Beltrano", true));
			repository.save(new ContaBancaria("55781-9", "Ciclano", true ));
		};

	}

}
