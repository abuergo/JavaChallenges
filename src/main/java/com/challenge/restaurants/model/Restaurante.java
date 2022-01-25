package com.challenge.restaurants.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@ToString
@Getter
@Setter
@Document("restaurantes")
public class Restaurante {
    @Id
    private String id;
    private String nombre;
    private Ciudad ciudad;
    private Menu menuComida;
    private Menu menuBebidas;
    private String hora_inicio;
    private String hora_fin;
    private Date fecha_creacion;
}
