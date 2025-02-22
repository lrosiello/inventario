package com.lurodev.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarStock(Long idProducto, int cantidad) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(producto.getStock() + cantidad);
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }
    
    public Producto findById(Long id) {
    	 return productoRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}
