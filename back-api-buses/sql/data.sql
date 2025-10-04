INSERT INTO marca (nombre)
VALUES ('Volvo'),
       ('Scania'),
       ('Fiat'),
       ('Mercedes-Benz');

INSERT INTO bus (numero_bus, placa, caracteristica, marca_id, activo)
VALUES ('101', 'ABC-123', '2 pisos, aire acondicionado', 1, TRUE),
       ('202', 'XYZ-987', '1 piso, asientos reclinables', 2, TRUE),
       ('303', 'JKL-456', 'Ecológico, eléctrico', 3, FALSE);