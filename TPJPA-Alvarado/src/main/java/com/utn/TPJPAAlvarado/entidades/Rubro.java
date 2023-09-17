package com.utn.TPJPAAlvarado.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntidad{
    private String denominacion;
    private Producto productos;
    @OneToMany
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod) {

        Producto.builder(prod);} //SE LO TUVE QUE CAMBIAR YA QUE NO ME TOMABA "ADD"


    public void mostrarProductos () {
        System.out.println("Los productos de este rubro son: ");
        for (Producto producto : productos) {
            System.out.println("Denominacion: " + producto.getDenominacion() + ", Receta: " + producto.getReceta()
                    + ", Unidad Medida: " + producto.getUnidadMedida() + ", Precio Compra: " + producto.getPrecioCompra()
                    + ", Precio Venta: " + producto.getPrecioVenta() + ", Stock Actual: " + producto.getStockActual()
                    + ", Stock Min: " + producto.getStockMinimo() + ", Tiempo Estimado Cocina: " + producto.getTiempoEstimadoCocina()
                    + ", Tipo: " + producto.getTipo());
        }
    }
}

