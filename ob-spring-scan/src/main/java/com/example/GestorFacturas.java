package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    // 1. Atributos
    Calculadora calculadora;

    // 2. Constructor

    public GestorFacturas(Calculadora calculadora) {
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
    }


    // 3. Métodos...
}