 CREATE TABLE IF NOT EXISTS entidades (
   entidad_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   nombre VARCHAR(255)
 );

 CREATE TABLE IF NOT EXISTS cuentas (
   cuenta_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   numero_cuenta VARCHAR(255),
   tipo VARCHAR(255),
   saldo_inicial FLOAT,
   estado BOOLEAN,
   cliente_id BIGINT,
   entidad_id BIGINT,
   FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id),
   FOREIGN KEY (entidad_id) REFERENCES entidades(entidad_id)
 );

 CREATE TABLE IF NOT EXISTS movimientos (
   movimiento_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   fecha DATE,
   tipo_movimiento VARCHAR(255),
   valor FLOAT,
   saldo FLOAT,
   entidad_id BIGINT,
   cuenta_id BIGINT,
   FOREIGN KEY (entidad_id) REFERENCES entidades(entidad_id),
   FOREIGN KEY (cuenta_id) REFERENCES cuentas(cuenta_id)
 );
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