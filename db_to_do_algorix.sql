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