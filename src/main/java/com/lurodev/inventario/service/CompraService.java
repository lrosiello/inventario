package com.lurodev.inventario.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lurodev.inventario.entity.Compra;
import com.lurodev.inventario.entity.Producto;
import com.lurodev.inventario.entity.Categoria;
import com.lurodev.inventario.entity.Proveedor;
import com.lurodev.inventario.repository.CompraRepository;
import com.lurodev.inventario.repository.ProductoRepository;
import com.lurodev.inventario.repository.CategoriaRepository;
import com.lurodev.inventario.repository.ProveedorRepository;

@Service
public class CompraService {
	private static final Logger logger = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProveedorRepository proveedorRepository;

	public Compra realizarCompra(Compra compra) {
		try {
			if (compra.getProducto().getId() == null || compra.getProducto().getId() <= 0) {
				throw new IllegalArgumentException("El ID del producto es inválido");
			}

			if (compra.getProducto().getCategoria().getId() == null
					|| compra.getProducto().getCategoria().getId() <= 0) {
				throw new IllegalArgumentException("El ID de la categoría es inválido");
			}

			if (compra.getProveedor().getId() == null || compra.getProveedor().getId() <= 0) {
				throw new IllegalArgumentException("El ID del proveedor es inválido");
			}

			Proveedor proveedor = proveedorRepository.findById(compra.getProveedor().getId()).orElse(null);
			if (proveedor == null) {
				logger.info("Proveedor no encontrado, creando nuevo: {}", compra.getProveedor());
				proveedor = proveedorRepository.save(compra.getProveedor());
			}

			Categoria categoria = categoriaRepository.findById(compra.getProducto().getCategoria().getId())
					.orElse(null);
			if (categoria == null) {
				logger.info("Categoría no encontrada, creando nueva: {}", compra.getProducto().getCategoria());
				categoria = categoriaRepository.save(compra.getProducto().getCategoria());
			}

			Producto producto = productoRepository.findById(compra.getProducto().getId()).orElse(null);
			if (producto == null) {
				logger.info("Producto no encontrado, creando nuevo: {}", compra.getProducto());
				producto = new Producto(compra.getProducto().getId(),
				        compra.getProducto().getDescripcion(), categoria, compra.getProducto().getCosto(),
				        compra.getProducto().getPrecio(), compra.getCantidad());
				producto = productoRepository.save(producto);
			} else {
				logger.info("Producto encontrado, actualizando stock: {}", producto);
				producto.setStock(producto.getStock() + compra.getCantidad());
				productoRepository.save(producto);
			}

			compra.setProveedor(proveedor);
			compra.setProducto(producto);

			Compra compraGuardada = compraRepository.save(compra);
			logger.info("Compra realizada con éxito: {}", compraGuardada);
			return compraGuardada;
		} catch (Exception e) {
			logger.error("Error al realizar la compra", e);
			throw new RuntimeException("Error al realizar la compra: " + e.getMessage(), e);
		}
	}

	public List<Compra> obtenerTodas() {
		return compraRepository.findAll();
	}
}
