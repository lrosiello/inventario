DELETE FROM compra;
DELETE FROM proveedor;
DELETE FROM producto;
DELETE FROM categoria;

-- Insertar proveedores
INSERT INTO proveedor (id, nombre, descripcion) VALUES 
(1, 'Proveedor A', 'Proveedor especializado en papeleria y escritura'),
(2, 'Proveedor B', 'Proveedor especializado en jugueteria');

-- Insertar categorias
INSERT INTO categoria (id, descripcion) VALUES 
(1, 'Papeleria'),
(2, 'Escritura'),
(3, 'Jugueteria');

-- Insertar productos
INSERT INTO producto (id, descripcion, id_categoria, costo, precio, stock) VALUES 
(4634734734, 'Cuaderno A4', 1, 100.0, 150.0, 30),
(8685644584, 'Lapiz HB', 2, 10.0, 15.0, 100),
(3232372323, 'Marcador permanente', 1, 25.0, 40.0, 50),
(5845845845, 'Borrador goma', 2, 15.0, 25.0, 20),
(3463463463, 'Tijeras escolares', 1, 50.0, 70.0, 15),
(3463474373, 'Lapiceras azul', 2, 20.0, 30.0, 80),
(5485484585, 'Juguete de construcción', 3, 300.0, 450.0, 10),
(3473477347, 'Pelota de futbol', 3, 200.0, 300.0, 5),
(2637474377, 'Muneca de trapo', 3, 150.0, 250.0, 12),
(5854845845,'Juego de mesa', 3, 500.0, 700.0, 8);

-- Insertar compras
INSERT INTO compra (id, id_producto, fecha, id_proveedor, cantidad) VALUES
(1, 4634734734, '2025-01-10', 1,30),  -- Cuaderno A4 comprado a Proveedor A
(2, 8685644584, '2025-01-12', 1,20),  -- Lápiz HB comprado a Proveedor A
(3, 3232372323, '2025-01-12', 1,20),  -- Marcador permanente comprado a Proveedor A
(4, 5845845845, '2025-01-13', 1,20),  -- Borrador goma comprado a Proveedor A
(5, 3463463463, '2025-01-13', 1,20),  -- Tijeras escolares compradas a Proveedor A
(6, 5485484585, '2025-01-14', 2,5),  -- Juguete de construccion comprado a Proveedor B
(7, 3473477347, '2025-01-14', 2,10),  -- Pelota de futbol comprada a Proveedor B
(8, 2637474377, '2025-01-14', 2,2),  -- Muneca de trapo comprada a Proveedor B
(9, 5854845845, '2025-01-14', 2,1); -- Juego de mesa comprado a Proveedor B
