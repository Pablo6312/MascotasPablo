-- Propietarios
INSERT INTO propietario (id, nombre, direccion, telefono) VALUES (1, 'Juan Pérez', 'Calle 123', '123456789');
INSERT INTO propietario (id, nombre, direccion, telefono) VALUES (2, 'Ana Gómez', 'Avenida 456', '987654321');

-- Mascotas
INSERT INTO mascota (id, nombre, fecha_nac, raza, peso, tiene_chip, url_foto, propietario_id) VALUES 
(1, 'Firulais', '2022-05-10', 'Labrador', 20.5, TRUE, 'http://foto1.com', 1);

INSERT INTO mascota (id, nombre, fecha_nac, raza, peso, tiene_chip, url_foto, propietario_id) VALUES 
(2, 'Misu', '2021-03-15', 'Persa', 5.0, FALSE, 'http://foto2.com', 2);

INSERT INTO mascota (id, nombre, fecha_nac, raza, peso, tiene_chip, url_foto, propietario_id) VALUES 
(3, 'Toby', '2023-01-20', 'Beagle', 10.0, TRUE, 'http://foto3.com', 1);
