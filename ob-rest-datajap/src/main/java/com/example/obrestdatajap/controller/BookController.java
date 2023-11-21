package com.example.obrestdatajap.controller;

import com.example.obrestdatajap.entities.Book;
import com.example.obrestdatajap.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    // Atributos
    private BookRepository bookRepository;
    // Construct

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // CRUD sobre la entidad Book
    // Buscar todos los libros (lista de libros)

    /**
    * http://localhost:8080/api/books
    * @return
    */
    @GetMapping("/api/books") // el nombre de la entidad en plural y api porque es una api rest
    public List<Book> findAll(){
        // Recuperar y devolver los libros de bases de datos
        return bookRepository.findAll();
    }

    // Buscar un solo libro en la base de datos según su id
    @GetMapping("/api/books/{id}") // {id} es un parametro variable que generara por ejemplo /api/book/2
    public ResponseEntity<Book> findOneById(@PathVariable Long id) { // @PathVariable vincula id con {id}

        Optional<Book> bookOpt = bookRepository.findById(id); // @PathVariable envuelve el id y el null
        // Opción 1

        if(bookOpt.isPresent()) {
            // Con ResponseEntity obtenemos un 404 si no se encuentra el libro.
            return ResponseEntity.ok(bookOpt.get()); // devuelve el libro.
        } else {
            return ResponseEntity.notFound().build();
        }

        // Opción 2
        //return bookOpt.orElse(null);
        // Opción 2 con ResponseEntity
        // return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo libro en la base de datos
    @PostMapping("/api/books") // Como son metodos diferentes no colisionan las url
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){ // También podria devolver un void o lo que se necesite
        System.out.println(headers.get("User-Agent"));
        // Guardar el libro recibido por parámetro en la base de datos
        return bookRepository.save(book);
    }


    // Actualizar un libro en la base de datos

    // Borrar un libro en la base de datos

}
