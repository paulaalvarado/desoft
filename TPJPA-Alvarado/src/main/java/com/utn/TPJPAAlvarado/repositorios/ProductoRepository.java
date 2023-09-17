package com.utn.TPJPAAlvarado.repositorios;

import com.utn.TPJPAAlvarado.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
