package com.utn.TPJPAAlvarado.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends BaseEntidad {
    private String calle;
    private int numero;
    private String localidad;

    @ManyToOne
    private Cliente cliente;
}
