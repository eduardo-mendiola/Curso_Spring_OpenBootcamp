package com.example.obrestdatajap.controller;

import com.example.obrestdatajap.entities.Book;
import com.example.obrestdatajap.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // Atributos
    private BookRepository bookRepository;
    // Construct

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // CRUD sobre la entidad Book

    /**
     * Buscar todos los libros que hay en la base de datos (ArrayList de libros)
     * http://localhost:8080/api/books
     * @return
    */
    @GetMapping("/api/books") // el nombre de la entidad en plural y api porque es una api rest
    public List<Book> findAll(){
        // Recuperar y devolver los libros de bases de datos
        return bookRepository.findAll();
    }

    /**
     * http://localhost:8080/api/books/1 ...etc
     * Request
     * Response
     * @param id
     * @return
     */

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
        // return bookOpt.orElse(null);
        // Opción 2 con ResponseEntity
        // return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo libro en la base de datos

    /**
     * Crear un nuevo libro en la base de datos
     * Método POST, no colisiona con findAll, porque son diferentes métodos HTTP: GET vs. POST
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/api/books") // Como son metodos diferentes no colisionan las url
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){ // También podria
        // devolver un void o
        // lo que se necesite
        System.out.println(headers.get("User-Agent")); // No siempre es necesario las cabeceras
        // Guardar el libro recibido por parámetro en la base de datos
        if (book.getId() != null){ // quiere decir que existe el id y por tanto no es una creación
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }


    /**
     * Actualizar un libro en la base de datos
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        if(book.getId() == null){ // si no tiene id quiere decir que si es una creación
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())) {
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        // El proceso de actualización
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); // el libro devuelto tiene una clave primaria
    }

    // Borrar un libro en la base de datos

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll() {
        log.info("REST Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
