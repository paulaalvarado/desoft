package com.utn.TPJPAAlvarado.entidades;

import com.fasterxml.jackson.databind.DatabindException;
import com.utn.TPJPAAlvarado.enumeraciones.FormaDePago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad {
    private int numero;
    private Date fecha;
    private double descuento;
    private FormaDePago formaDePago;
    private double total;
}
