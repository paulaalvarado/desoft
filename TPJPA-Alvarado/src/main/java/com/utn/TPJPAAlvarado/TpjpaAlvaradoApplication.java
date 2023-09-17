package com.utn.TPJPAAlvarado;


import com.utn.TPJPAAlvarado.entidades.*;
import com.utn.TPJPAAlvarado.enumeraciones.*;
import com.utn.TPJPAAlvarado.repositorios.ClienteRepository;
import com.utn.TPJPAAlvarado.repositorios.ProductoRepository;
import com.utn.TPJPAAlvarado.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TpjpaAlvaradoApplication {
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpjpaAlvaradoApplication.class, args);
	}
	SpringApplication.run(TpjpaAlvaradoApplication.class, args);
}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			// Código a ejecutar después de la inicialización de la aplicación
			Rubro rubro1 = Rubro.builder()
					.denominacion("Pizzas")
					.build();
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(90)
					.denominacion("Muzzarella")
					.precioVenta(2850)
					.precioCompra(1200)
					.stockActual(50)
					.stockMinimo(3)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipo(TipoProducto.Insumo)
					.build();
			Producto producto2 = Producto.builder()
					.tiempoEstimadoCocina(60)
					.denominacion("Fugazzetta")
					.precioVenta(3400)
					.precioCompra(1800)
					.stockActual(50)
					.stockMinimo(4)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipo(TipoProducto.Insumo)
					.build();
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			rubroRepository.save(rubro1);
			Cliente cliente1 = Cliente.builder()
					.nombre("Paula")
					.apellido("Alvarado")
					.email("paulaalvarado@gmail")
					.telefono("2613267700")
					.build();
			Domicilio domicilio1 = Domicilio.builder() //Crea dos instancias domicilio para el cliente
					.calle("Dr. Brandi")
					.numero(12)
					.localidad("Maipu")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Barrio AOMA M A")
					.numero(25)
					.localidad("Russell")
					.build();
			cliente1.agregarDomicilio(domicilio1); // Agrega los domicilios del cliente
			cliente1.agregarDomicilio(domicilio2);
			DetallePedido detallePedido1 = DetallePedido.builder() //Crea uan instancia de DetallePedido
					.cantidad(2)
					.subtotal(5200)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(5)
					.subtotal(10900)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(2850)
					.build();
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd"); // Configuración de la fecha
			String fechaString = "2023-09-16";
			Date fecha = formatoFecha.parse(fechaString); // Parsea la cadena en un objeto Date
			Pedido pedido1 = Pedido.builder() 	//Crea instancia de Pedido
					.fecha(fecha)
					.total(6292)
					.estado(Estado.Entregado)
					.tipoDeEnvio(TipoDeEnvio.Delivery)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(13189)
					.estado(Estado.Entregado)
					.tipoDeEnvio(TipoDeEnvio.Delivery)
					.build();
			Factura factura1 = Factura.builder() //Crear instancias de factura
					.fecha(fecha)
					.total(5800)
					.numero(1)
					.descuento(0)
					.formaDePago(FormaDePago.Efectivo)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha)
					.total(5400)
					.numero(2)
					.descuento(0)
					.formaDePago(FormaDePago.Efectivo)
					.build();
			pedido1.agregarDetallePedido(detallePedido1); // Agrega los detalles del pedido
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);
			cliente1.agregarPedido(pedido1); // Agrega los pedidos a su cliente
			cliente1.agregarPedido(pedido2);
			detallePedido1.setProducto(producto1); // Vincula el detalle del pedido con el producto
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto1);
			pedido1.setFactura(factura1); // Vincula la factura con el pedido
			pedido2.setFactura(factura2);
			clienteRepository.save(cliente1); // Guarda los datos de Cliente
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null); // Recupera al objeto Rubro desde la base de datos
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			// Recupera el objeto Cliente desde la base de datos
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();
			};
		};

	}}

