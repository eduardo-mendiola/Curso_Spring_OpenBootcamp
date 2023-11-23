package com.example.obrestdatajap.service;

import com.example.obrestdatajap.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {

        // 1. Configuración de la prueba
        Book book = new Book(1L, "El señor de los anillos", "Author", 1000, 49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // 2. Se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        // 3. Comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(57.980000000000004, price);
    }
}