package com.utn.TPJPAAlvarado.repositorios;

import com.utn.TPJPAAlvarado.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
