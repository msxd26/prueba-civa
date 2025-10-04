CREATE TABLE marca
(
    id     BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE bus
(
    id             BIGSERIAL PRIMARY KEY,
    numero_bus     VARCHAR(50),
    placa          VARCHAR(10),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    caracteristica VARCHAR(255),
    marca_id       BIGINT,
    activo         BOOLEAN,

    CONSTRAINT fk_bus_marca FOREIGN KEY (marca_id) REFERENCES marca (id)
);