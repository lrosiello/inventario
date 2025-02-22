package com.lurodev.inventario.controller;

import com.lurodev.inventario.dto.MovimientoStockDTO;
import com.lurodev.inventario.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/historial/{codigoBarras}")
    public List<MovimientoStockDTO> obtenerHistorialStock(@PathVariable Long codigoBarras) {
        return stockService.obtenerHistorialStock(codigoBarras);
    }
}
