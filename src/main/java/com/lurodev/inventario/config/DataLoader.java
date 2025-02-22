package com.lurodev.inventario.config;

import com.lurodev.inventario.entity.Categoria;
import com.lurodev.inventario.entity.Compra;
import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.entity.Proveedor;
import com.lurodev.inventario.entity.Venta;
import com.lurodev.inventario.repository.CategoriaRepository;
import com.lurodev.inventario.repository.CompraRepository;
import com.lurodev.inventario.repository.ProductoRepository;
import com.lurodev.inventario.repository.ProveedorRepository;
import com.lurodev.inventario.repository.VentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;
    private final CompraRepository compraRepository;
    private final VentaRepository ventaRepository;

    public DataLoader(ProductoRepository productoRepository, CategoriaRepository categoriaRepository,
                      ProveedorRepository proveedorRepository, CompraRepository compraRepository, VentaRepository ventaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.proveedorRepository = proveedorRepository;
        this.compraRepository = compraRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Cargando datos iniciales...");

        // Proveedores
        Proveedor p1 = new Proveedor(24634634436L, "Papeleria Central", "Proveedor especializado en papeleria y escritura");
        Proveedor p2 = new Proveedor(12263262632L, "Juguetoys", "Proveedor especializado en jugueteria");
        proveedorRepository.save(p1);
        proveedorRepository.save(p2);

        // Categorias
        Categoria c1 = new Categoria(null, "Papeleria");
        Categoria c2 = new Categoria(null, "Escritura");
        Categoria c3 = new Categoria(null, "Jugueteria");
        categoriaRepository.save(c1);
        categoriaRepository.save(c2);
        categoriaRepository.save(c3);

        // Productos
        Producto prod1 = new Producto(4634734734L, "Cuaderno A4", c1, 100.0, 150.0, 30);
        Producto prod2 = new Producto(8685644584L, "Lapiz HB", c2, 10.0, 15.0, 100);
        Producto prod3 = new Producto(3232372323L, "Marcador permanente", c1, 25.0, 40.0, 50);
        Producto prod4 = new Producto(5845845845L, "Borrador goma", c2, 15.0, 25.0, 20);
        Producto prod5 = new Producto(3463463463L, "Tijeras escolares", c1, 50.0, 70.0, 15);
        Producto prod6 = new Producto(3463474373L, "Lapiceras azul", c2, 20.0, 30.0, 80);
        Producto prod7 = new Producto(5485484585L, "Juguete de construcción", c3, 300.0, 450.0, 10);
        Producto prod8 = new Producto(3473477347L, "Pelota de futbol", c3, 200.0, 300.0, 5);
        Producto prod9 = new Producto(2637474377L, "Muneca de trapo", c3, 150.0, 250.0, 12);
        Producto prod10 = new Producto(5854845845L, "Juego de mesa", c3, 500.0, 700.0, 8);
        productoRepository.saveAll(java.util.List.of(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10));

        // Compras
        compraRepository.save(new Compra(null, prod1, LocalDate.of(2025, 1, 10), p1, 30));
        compraRepository.save(new Compra(null, prod2, LocalDate.of(2025, 1, 12), p1, 20));
        compraRepository.save(new Compra(null, prod3, LocalDate.of(2025, 1, 12), p1, 20));
        compraRepository.save(new Compra(null, prod4, LocalDate.of(2025, 1, 13), p1, 20));
        compraRepository.save(new Compra(null, prod5, LocalDate.of(2025, 1, 13), p1, 20));
        compraRepository.save(new Compra(null, prod7, LocalDate.of(2025, 1, 14), p2, 5));
        compraRepository.save(new Compra(null, prod8, LocalDate.of(2025, 1, 14), p2, 10));
        compraRepository.save(new Compra(null, prod9, LocalDate.of(2025, 1, 14), p2, 2));
        compraRepository.save(new Compra(null, prod10, LocalDate.of(2025, 1, 14), p2, 1));

        // Venta
        ventaRepository.save(new Venta(null, prod1, LocalDate.of(2025, 2, 1), 5));
        
        System.out.println("Datos cargados exitosamente.");
    }
}

