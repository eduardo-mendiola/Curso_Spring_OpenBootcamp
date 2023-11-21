package com.example.obspringjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringjpaApplication.class, args);

		CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("find");
		System.out.println("El número de coches en base de datos es: " + repository.count());



		// Crear y almacenar un coche en base de datos
		Coche toyota = new Coche(null,"Toyota", "Primus", 2010);
		repository.save(toyota);

		System.out.println("El número de coches en base de datos es: " + repository.count());

		// Recuperar un coche por id.
		System.out.println(repository.findAll());


	}

}
