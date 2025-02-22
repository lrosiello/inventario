package com.lurodev.inventario.service;

import com.lurodev.inventario.dto.MovimientoStockDTO;
import com.lurodev.inventario.entity.Compra;
import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.entity.Venta;
import com.lurodev.inventario.repository.CompraRepository;
import com.lurodev.inventario.repository.ProductoRepository;
import com.lurodev.inventario.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private VentaRepository ventaRepository;

	public List<MovimientoStockDTO> obtenerHistorialStock(Long codigoBarras) {
		Optional<Producto> producto = productoRepository.findById(codigoBarras);
		if (producto.isEmpty()) {
			throw new RuntimeException("Producto no encontrado con el código de barras: " + codigoBarras);
		}

		List<MovimientoStockDTO> movimientos = new ArrayList<>();

		// Movimientos de compra
		List<Compra> compras = compraRepository.findByProductoId(codigoBarras);
		compras.forEach(compra -> movimientos.add(new MovimientoStockDTO(compra.getFecha().atStartOfDay(), "COMPRA",
				compra.getCantidad(), 0)));

		// Movimientos de venta
		List<Venta> ventas = ventaRepository.findByProductoId(codigoBarras);
		ventas.forEach(venta -> movimientos.add(new MovimientoStockDTO(venta.getFecha().atStartOfDay(), "VENTA",
				venta.getCantidad(), 0)));

		// Ordenar por fecha
		movimientos.sort(
				Comparator.comparing(MovimientoStockDTO::getFecha, Comparator.nullsLast(Comparator.naturalOrder())));

		
		
		
		// Calcular stock en cada momento
		int stock = 0; // Stock inicial
		for (MovimientoStockDTO mov : movimientos) {
		    if ("COMPRA".equals(mov.getOperacion())) {
		        stock += mov.getCantidad();
		    } else if ("VENTA".equals(mov.getOperacion())) {
		        stock -= mov.getCantidad();
		    }
		    mov.setStockActual(stock); 
		}
		
		return movimientos;
	}
}
