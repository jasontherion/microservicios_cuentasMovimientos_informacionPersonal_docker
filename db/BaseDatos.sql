-- Inserción de datos en PERSONAS
INSERT INTO PERSONAS ( NOMBRE, GENERO, EDAD, IDENTIFICACION, DIRECCION, TELEFONO)
VALUES
    ( 'Juan Perez', 'M', 35, '123456789', 'Calle 123', '111-222-333'),
    ( 'Maria Lopez', 'F', 28, '987654321', 'Avenida 456', '444-555-666'),
    ( 'Carlos Gomez', 'M', 42, '555555555', 'Carrera 789', '777-888-999'),
    ( 'Ana Rodriguez', 'F', 50, '111111111', 'Plaza 101', '222-333-444'),
    ( 'Pedro Sanchez', 'M', 30, '222222222', 'Parque 202', '555-666-777');


-- Inserción de datos en CLIENTES (relacionando con PERSONAS)
INSERT INTO CLIENTES ( CONTRASENIA, ESTADO, PERSONA_ID)
VALUES
    ( 'contraseña123', true, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='123456789')),
    ( 'password456', true, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='987654321')),
    ( 'secure789', false, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='555555555')),
    ( 'clave101', true, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='111111111')),  -- Un cliente adicional para la persona 1
    ( 'pass202', false, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='222222222'));


 -- Inserts para la tabla ENTIDADES en PostgreSQL
 INSERT INTO ENTIDADES (NOMBRE) VALUES
 ('Banco de la Nación Argentina'),
 ('Banco do Brasil'),
 ('Banco Central de Chile'),
 ('Banco de la República de Colombia'),
 ('Banco Central del Ecuador'),
 ('Banco Central de Paraguay'),
 ('Banco de la República Oriental del Uruguay'),
 ('Banco Central de Venezuela'),
 ('Banco del Estado de Bolivia'),
 ( 'Banco Nacional de Costa Rica');