package com.lurodev.inventario.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    private LocalDate fecha;
    private int cantidad; 
    
    public Compra(Long id, Producto producto, LocalDate fecha, Proveedor proveedor, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

}
