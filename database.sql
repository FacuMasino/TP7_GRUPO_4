create schema SegurosGroup;

use SegurosGroup;

create table
    usuarios (
        nombreUsuario VARCHAR(25) NOT NULL PRIMARY KEY,
        pass VARCHAR(25),
        tipoUsuario INT,
        dni VARCHAR(10),
        nombre VARCHAR(50),
        apellido VARCHAR(50)
    );

create table
    tipoSeguros (
        idTipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        descripcion VARCHAR(50)
    );

create table
    seguros (
        idSeguro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        descripcion VARCHAR(200),
        idTipo INT,
        costoContratacion DECIMAL,
        costoAsegurado DECIMAL
    );

create table
    contratacion (
        idContratacion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        nombreUsuario VARCHAR(25),
        idSeguro INT,
        costoContratacion DECIMAL
    );

INSERT INTO
    usuarios (
        nombreUsuario,
        pass,
        tipoUsuario,
        dni,
        nombre,
        apellido
    )
VALUES
    ('admin', 'admin', 1, 30600282, 'Pepe', 'Perez');

INSERT INTO
    usuarios (
        nombreUsuario,
        pass,
        tipoUsuario,
        dni,
        nombre,
        apellido
    )
VALUES
    (
        'user1',
        'user1',
        2,
        30600282,
        'Marcela',
        'Fernandez'
    );

INSERT INTO
    usuarios (
        nombreUsuario,
        pass,
        tipoUsuario,
        dni,
        nombre,
        apellido
    )
VALUES
    (
        'user2',
        'user2',
        2,
        30600282,
        'Jose',
        'Rodriguez'
    );

INSERT INTO
    tipoSeguros (descripcion)
VALUES
    ('Seguro de casas');

INSERT INTO
    tipoSeguros (descripcion)
VALUES
    ('Seguro de vida');

INSERT INTO
    tipoSeguros (descripcion)
VALUES
    ('Seguro de motos');

INSERT INTO
    seguros (
        descripcion,
        idTipo,
        costoContratacion,
        costoAsegurado
    )
VALUES
    (
        'Es un seguro de salud para intervenciones quirúrgicas de alta complejidad, a un costo accesible.',
        1,
        600,
        15000
    );

INSERT INTO
    seguros (
        descripcion,
        idTipo,
        costoContratacion,
        costoAsegurado
    )
VALUES
    (
        'Asegura toda la gama de motocicletas de uso particular, desde motos y ciclomotores hasta deportivas: street, custom, enduro, scooter y choperas, entre otras.',
        3,
        1200,
        28000
    );

INSERT INTO
    contratacion (nombreUsuario, idSeguro, costoContratacion)
VALUES
    ('user1', 3, 1200);

INSERT INTO
    contratacion (nombreUsuario, idSeguro, costoContratacion)
VALUES
    ('user2', 1, 600);

CREATE PROCEDURE traerTodosUsuarios ()
Select
    *
from
    usuarios;

CREATE PROCEDURE traerUnUsuarios (NombreU VARCHAR(25))
SELECT
    *
from
    usuarios
where
    nombreUsuario = NombreU;