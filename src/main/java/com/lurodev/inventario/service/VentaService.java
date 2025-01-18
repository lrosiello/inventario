package com.lurodev.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.entity.Venta;
import com.lurodev.inventario.repository.ProductoRepository;
import com.lurodev.inventario.repository.VentaRepository;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Venta realizarVenta(Venta venta) {
        // Actualizamos el stock del producto
        Producto producto = productoRepository.findById(venta.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        if (producto.getStock() < venta.getCantidad()) {
            throw new RuntimeException("Stock insuficiente para realizar la venta");
        }
        
        producto.setStock(producto.getStock() - venta.getCantidad());
        productoRepository.save(producto);

        return ventaRepository.save(venta);
    }

    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }

}
