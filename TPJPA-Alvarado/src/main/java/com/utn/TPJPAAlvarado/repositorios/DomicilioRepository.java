package com.utn.TPJPAAlvarado.repositorios;

import com.utn.TPJPAAlvarado.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
