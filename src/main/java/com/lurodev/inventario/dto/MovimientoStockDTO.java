package com.lurodev.inventario.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MovimientoStockDTO {
    private LocalDateTime fecha;
    private String operacion; // "COMPRA" o "VENTA"
    private int cantidad;
    private int stockActual;

    public MovimientoStockDTO(LocalDateTime fecha, String operacion, int cantidad, int stockActual) {
        this.fecha = fecha;
        this.operacion = operacion;
        this.cantidad = cantidad;
        this.stockActual = stockActual;
    }


	// Getters y Setters
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getOperacion() { return operacion; }
    public void setOperacion(String operacion) { this.operacion = operacion; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getStockActual() { return stockActual; }
    public void setStockActual(int stockActual) { this.stockActual = stockActual; }
}
