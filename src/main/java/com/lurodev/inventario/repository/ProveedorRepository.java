package com.lurodev.inventario.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lurodev.inventario.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}
