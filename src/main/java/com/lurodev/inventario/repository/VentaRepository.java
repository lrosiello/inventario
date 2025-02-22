package com.lurodev.inventario.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lurodev.inventario.entity.Compra;
import com.lurodev.inventario.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

	List<Venta> findByProductoId(Long productoId);
}

