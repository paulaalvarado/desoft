package com.utn.TPJPAAlvarado.entidades;

import com.utn.TPJPAAlvarado.enumeraciones.TipoProducto;
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
public class Producto {
    private TipoProducto tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockMinimo;
    private int stockActual;
    private String unidadMedida;
    private String receta;
    private DetallePedido productos;

    @ManyToOne
    private Rubro rubro;
}
