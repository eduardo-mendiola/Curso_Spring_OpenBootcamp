package com.example.obspringjpa;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {

    // atributos encapsulados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private String model;
    private Integer fabric_year;

    // constructores

    public Coche() {
    }

    public Coche(Long id, String manufacturer, String model, Integer fabric_year) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.fabric_year = fabric_year;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getFabric_year() {
        return fabric_year;
    }

    public void setFabric_year(Integer year) {
        this.fabric_year = year;
    }


    // tostring


    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", fabric_year=" + fabric_year +
                '}';
    }
}
