package com.utn.TPJPAAlvarado.entidades;

import com.utn.TPJPAAlvarado.enumeraciones.TipoProducto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List; // Importa la clase List desde el paquete correcto

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto extends BaseEntidad {
    private TipoProducto tipo;
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockMinimo;
    private int stockActual;
    private String unidadMedida;
    private String receta;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallesPedidos = new ArrayList<>();

    @ManyToOne
    private Rubro rubro;
}

