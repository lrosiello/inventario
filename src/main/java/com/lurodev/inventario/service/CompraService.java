package com.lurodev.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lurodev.inventario.entity.Compra;
import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.repository.CompraRepository;
import com.lurodev.inventario.repository.ProductoRepository;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;
    
    @Autowired
    private ProductoRepository productoRepository;

    public Compra realizarCompra(Compra compra) {
        // Actualizamos el stock del producto
        Producto producto = productoRepository.findById(compra.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(producto.getStock() + compra.getCantidad());
        productoRepository.save(producto);

        return compraRepository.save(compra);
    }

    public List<Compra> obtenerTodas() {
        return compraRepository.findAll();
    }


}
