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
    @OneToMany
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto prod) {

        productos.add(prod);}


    public void mostrarProductos () {
        System.out.println("Los productos de este rubro son: ");
        for (Producto producto : productos) {
            System.out.println("Denominación: " + producto.getDenominacion() + ", Receta: " + producto.getReceta()
                    + ", Unidad de medida: " + producto.getUnidadMedida() + ", Precio de compra: " + producto.getPrecioCompra()
                    + ", Precio de venta: " + producto.getPrecioVenta() + ", Stock actual: " + producto.getStockActual()
                    + ", Stock mínimo: " + producto.getStockMinimo() + ", Tiempo estimado en cocina: " + producto.getTiempoEstimadoCocina()
                    + ", Tipo: " + producto.getTipo());
        }
    }
}

