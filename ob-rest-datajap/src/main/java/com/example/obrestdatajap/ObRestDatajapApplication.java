package com.example.obrestdatajap;

import com.example.obrestdatajap.entities.Book;
import com.example.obrestdatajap.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajapApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajapApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		// CRUD
		// crear libro
		Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018,12,1), true);
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 210, 19.99, LocalDate.of(2013,7,5), true);
		// almacenar un libro
		System.out.println("Números de libros en la base de datos: " + repository.findAll().size());


		repository.save(book1);
		repository.save(book2);

		// recuperar todos los libros
		System.out.println("Números de libros en la base de datos: " + repository.findAll().size());

		// borrar un libro
		//repository.deleteById(1L); // L es del tipo de dato Long

		System.out.println("Números de libros en la base de datos: " + repository.findAll().size());
	}

}
