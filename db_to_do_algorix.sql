drop database if exists db_to_do_algorix;
create database db_to_do_algorix;

use db_to_do_algorix;

create table Usuarios(
	id_usuario int not null auto_increment,
    nombre varchar(64),
    apellido varchar(64),
    telefono varchar (16),
    correo varchar (128),
    pass varchar (32),
    constraint pk_usuario primary key(id_usuario)
);

create table Tareas(
	id_tarea int not null auto_increment,
    titulo varchar(255),
    descripcion text,
    fecha_limite date,
    estado enum('pendiente', 'teminada'),
    id_usuario int,
    constraint pk_tareas primary key (id_tarea),
    constraint fk_taraa_usuario foreign key(id_usuario)
		references Usuarios(id_usuario)
);

INSERT INTO Usuarios (nombre, apellido, telefono, correo, pass) VALUES
('Emiliano', 'Herrera', '5551234567', 'emiliano.herrera@example.com', '1234'),
('Laura', 'Gómez', '5552345678', 'laura.gomez@example.com', 'abcd'),
('Carlos', 'Martínez', '5553456789', 'carlos.martinez@example.com', 'pass123'),
('Ana', 'López', '5554567890', 'ana.lopez@example.com', 'lopez2024'),
('Miguel', 'Ramírez', '5555678901', 'miguel.ramirez@example.com', 'migue321');

INSERT INTO Tareas (titulo, descripcion, fecha_limite, estado, id_usuario) VALUES
('Comprar materiales', 'Comprar lápices, hojas y carpetas para la oficina', '2025-09-05', 'pendiente', 1),
('Revisar informes', 'Analizar los informes financieros del trimestre', '2025-09-10', 'teminada', 1),

('Actualizar sitio web', 'Modificar el contenido de la página principal', '2025-09-07', 'pendiente', 2),
('Enviar correos', 'Enviar boletín informativo a todos los clientes', '2025-09-08', 'teminada', 2),

('Diseñar logo', 'Crear un nuevo logo para el producto', '2025-09-12', 'pendiente', 3),
('Presentación de ventas', 'Preparar presentación para la reunión de ventas', '2025-09-09', 'teminada', 3),

('Capacitación interna', 'Organizar capacitación para nuevos empleados', '2025-09-15', 'pendiente', 4),
('Documentar procesos', 'Actualizar documentación de procesos internos', '2025-09-11', 'teminada', 4),

('Mantenimiento del servidor', 'Revisar logs y realizar mantenimiento programado', '2025-09-14', 'pendiente', 5),
('Planificación mensual', 'Definir metas y entregables del mes siguiente', '2025-09-13', 'teminada', 5);

