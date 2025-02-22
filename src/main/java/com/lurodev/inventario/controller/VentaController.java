package com.lurodev.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lurodev.inventario.dto.CompraDTO;
import com.lurodev.inventario.dto.VentaDTO;
import com.lurodev.inventario.entity.Categoria;
import com.lurodev.inventario.entity.Compra;
import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.entity.Proveedor;
import com.lurodev.inventario.entity.Venta;
import com.lurodev.inventario.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/api/ventas")
    public ResponseEntity<Venta> realizarVenta(@RequestBody VentaDTO ventaDTO) {
    	Producto producto = new Producto();
    	producto.setId(ventaDTO.getProductoId());
    	

        Venta venta = new Venta();
        venta.setProducto(producto);
        venta.setFecha(ventaDTO.getFecha());
        venta.setCantidad(ventaDTO.getCantidad());

        Venta nuevaVenta = ventaService.realizarVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodas() {
        return ResponseEntity.ok(ventaService.obtenerTodas());
    }


}

