package com.example.demo.Entidades;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Set;

import java.util.HashSet;

@Entity
@Table(name = "Autor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor extends Base {
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "biografia" , length = 1500)
    private String biografia;
}