package com.learning_api.demo.entitys;

import javax.persistence.*;


@Entity  //Indicamos que es una entidad de base de datos
@Table(name = "products") // Indicamos en que tabla de la BD se guardará
public class Product {

    // Con las anotaciones de cada columna JPA generara la tabla con dichas especificaciones

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa el id
    private Long id;

    @Column(name = "name",nullable = false,length = 30) // no null
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// https://docs.docker.com/engine/install/linux-postinstall/