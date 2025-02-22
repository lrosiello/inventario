package com.lurodev.inventario.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lurodev.inventario.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	List<Compra> findByProductoId(Long productoId);
}

