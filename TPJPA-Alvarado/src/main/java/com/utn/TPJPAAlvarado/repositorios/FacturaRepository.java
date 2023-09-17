package com.utn.TPJPAAlvarado.repositorios;

import com.utn.TPJPAAlvarado.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
