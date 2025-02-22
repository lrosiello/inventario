package com.lurodev.inventario.entity;

import jakarta.persistence.Entity;
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
public class Producto {
    @Id
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    private double costo;
    private double precio;
    private int stock; 
    
    public Producto(Long id, String descripcion, Categoria categoria, double costo, double precio, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
    }

}