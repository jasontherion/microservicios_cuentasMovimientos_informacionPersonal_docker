-- Inserción de datos en PERSONAS
INSERT INTO PERSONAS (PERSONA_ID, NOMBRE, GENERO, EDAD, IDENTIFICACION, DIRECCION, TELEFONO)
VALUES
    (1, 'Juan Perez', 'M', 35, '123456789', 'Calle 123', '111-222-333'),
    (2, 'Maria Lopez', 'F', 28, '987654321', 'Avenida 456', '444-555-666'),
    (3, 'Carlos Gomez', 'M', 42, '555555555', 'Carrera 789', '777-888-999'),
    (4, 'Ana Rodriguez', 'F', 50, '111111111', 'Plaza 101', '222-333-444'),
    (5, 'Pedro Sanchez', 'M', 30, '222222222', 'Parque 202', '555-666-777');


-- Inserción de datos en CLIENTES (relacionando con PERSONAS)
INSERT INTO CLIENTES (CLIENTE_ID, CONTRASENIA, ESTADO, PERSONA_ID)
VALUES
    (1, 'contraseña123', true, 1),
    (2, 'password456', true, 2),
    (3, 'secure789', false, 3),
    (4, 'clave101', true, 1),  -- Un cliente adicional para la persona 1
    (5, 'pass202', false, 5);