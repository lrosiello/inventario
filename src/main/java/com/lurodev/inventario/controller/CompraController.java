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
import com.lurodev.inventario.entity.Categoria;
import com.lurodev.inventario.entity.Compra;
import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.entity.Proveedor;
import com.lurodev.inventario.service.CompraService;


@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;


    @PostMapping("/api/compras")
    public ResponseEntity<Compra> crearCompra(@RequestBody CompraDTO compraDTO) {
    	Producto producto = new Producto();
    	producto.setId(compraDTO.getProductoId());
    	
    	Categoria categoria = new Categoria();
        categoria.setId(compraDTO.getCategoriaId());
        producto.setCategoria(categoria);

    	Proveedor proveedor = new Proveedor();
    	proveedor.setId(compraDTO.getProveedorId());


        Compra compra = new Compra();
        compra.setProducto(producto);
        compra.setProveedor(proveedor);
        compra.setFecha(compraDTO.getFecha());
        compra.setCantidad(compraDTO.getCantidad());

        Compra nuevaCompra = compraService.realizarCompra(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCompra);
    }


    @GetMapping
    public ResponseEntity<List<Compra>> obtenerTodas() {
        return ResponseEntity.ok(compraService.obtenerTodas());
    }

}
