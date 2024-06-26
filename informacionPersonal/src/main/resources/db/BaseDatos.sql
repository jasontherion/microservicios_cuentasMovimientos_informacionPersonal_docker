--Schema de las tablas utilizadas

CREATE TABLE IF NOT EXISTS personas (
  persona_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  nombre VARCHAR(255) NOT NULL,
  genero VARCHAR(255) NOT NULL,
  edad INT NOT NULL,
  identificacion VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  telefono VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS clientes (
  cliente_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  contrasenia VARCHAR(255),
  estado BOOLEAN,
  persona_id BIGINT NOT NULL,
  FOREIGN KEY (persona_id) REFERENCES personas(persona_id)
);




-- Inserción de datos en PERSONAS
INSERT INTO PERSONAS ( NOMBRE, GENERO, EDAD, IDENTIFICACION, DIRECCION, TELEFONO)
VALUES
    ( 'Juan Perez', 'M', 35, '123456789', 'Calle 123', '111-222-333'),
    ( 'Maria Lopez', 'F', 28, '987654321', 'Avenida 456', '444-555-666'),
    ( 'Carlos Gomez', 'M', 42, '555555555', 'Carrera 789', '777-888-999'),
    ( 'Ana Rodriguez', 'F', 50, '111111111', 'Plaza 101', '222-333-444'),
    ( 'Pedro Sanchez', 'M', 30, '222222222', 'Parque 202', '555-666-777');
--     ( 'Jason Therion', 'M', 30, '666666', 'Parque 606', '66-666-777');


-- Inserción de datos en CLIENTES (relacionando con PERSONAS)
INSERT INTO CLIENTES ( CONTRASENIA, ESTADO, PERSONA_ID)
VALUES
    ( 'contraseña123', true, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='123456789')),
    ( 'password456', true, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='987654321')),
    ( 'secure789', false, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='555555555')),
    ( 'clave101', true, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='111111111')),  -- Un cliente adicional para la persona 1
    ( 'pass202', false, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='222222222'));
--    ( 'pass606', false, (SELECT PERSONA_ID FROM PERSONAS WHERE IDENTIFICACION='666666'));

