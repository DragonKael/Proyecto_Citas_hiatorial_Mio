SET GLOBAL time_zone = '-5:00';
drop database if exists bd_cita_medica;
create database bd_cita_medica;
use bd_cita_medica; 
-- set sql_mode='';
drop table if exists tusuario;
create table tusuario 
(
	id_usuario int not null primary key,
	nombre_usuario varchar(50),
	nombre varchar(50),
	apaterno varchar(50),
    amaterno varchar(50),
	email varchar(100),
	contrasenia varchar(60),
	es_activo boolean not null  default true,
	es_administrador boolean not null default false,
	creado_en datetime
);

-- insert into usuario (nombre_usuario,contrasenia,es_administrador,es_activo,creado_en) value ("admin",sha1(md5("admin")),1,1,noW());
-- Login valid_o del usuario: select * from user where (email=”EmaiL” and password=”password”) and is_active=1
-- select * from usuario
drop table if exists tpaciente;
create table tpaciente 
(
	id_paciente int not null primary key,
	cod_personal varchar(50),
	nombre varchar(50),
	apaterno varchar(50),
    amaterno varchar(50),
	genero char(1),
	dia_nace date,
	email varchar(100),
	direccion varchar(50),
	telefono varchar(15),
	imagen text,
    grupo_sanguineo varchar(3),
	es_favorito boolean not null default true,
	es_activo boolean not null default true,
	creado_en datetime
);

drop table if exists tcategoria;
create table tcategoria 
(
	id_categoria int not null primary key,
	nombre varchar(200),
    creado_en datetime
);

drop table if exists tlaboratorio;
create table tlaboratorio
(
	id_laboratorio int primary key,
    nombre varchar(50),
    aforo int,
    descripcion text,
    creado_en datetime
);

drop table if exists tespecialidad;
create table tespecialidad
(
	id_especialidad int primary key,
    nombre varchar(200),
    id_categoria int,
    creado_en datetime,
    id_laboratorio int,
    foreign key (id_categoria) references tcategoria(id_categoria),
    foreign key (id_laboratorio) references tlaboratorio(id_laboratorio)
);

-- insert into categoria (nombre) value ("modulo 1");

drop table if exists tmedico;
create table tmedico 
(
	id_medico int not null  primary key,
	cod_personal varchar(50),
	nombre varchar(50),
	apaterno varchar(50),
    amaterno varchar(50),
	genero varchar(1),
	dia_nace date,
	email varchar(100),
	direccion varchar(50),
	telefono varchar(15),
	imagen text,
	es_activo boolean not null default true,
	creado_en datetime,
	id_especialidad int,
	foreign key (id_especialidad) references tespecialidad(id_especialidad)
);



-- drop table if exists testado;
-- create table testado (
-- 	id_estado int not null primary key,
-- 	nombre varchar(100),
--     creado_en datetime
-- );

-- insert into status (id_,name) values (1,"pendiente"), (2,"aplicada"),(3,"no asistio"),(4,"Cancelada"),(5,"En atencion"),(6,"finalizado");

-- drop table if exists tpago;
-- create table tpago 
-- (
-- 	id_pago int not null primary key,
-- 	nombre varchar(100),
--     creado_en datetime
-- );
-- 
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------

-- insert into payment (id_,name) values  (1,"pendiente"),(2,"pagado"),(3,"anulado");

drop table if exists tantecedente;
create table tantecedente
(
	id_antecedente int primary key,
    alergias text,
    enfermedades text,
    medicamentos text,
    creado_en datetime
);

drop table if exists ttriaje;
create table ttriaje
(
	id_triaje int primary key,
    peso double,
    talla double,
    presion_sanguinea double,
    nivel varchar(9),
    color varchar (10),
    categoria varchar(25),
    tiempo_atencion varchar(50),
    detalles text
);

-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------

drop table if exists tmedicamento;
create table if not exists tmedicamento
(
	id_medicamento int primary key,
    nombre varchar(100),
    tipo varchar(100),
    medio varchar(50),
    unidad_medida varchar(10),
    descripcion text
);

-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------

drop table if exists thistoria;
create table thistoria
(
	id_historia int primary key,
    id_paciente int,
    nombre_clinica varchar(100),
    creado_en datetime,
    id_usuario int,
    id_antecedente int,
    foreign key (id_paciente) references tpaciente(id_paciente),
    foreign key (id_usuario) references tusuario(id_usuario),
    foreign key (id_antecedente) references tantecedente(id_antecedente)
);

drop table if exists treserva;
create table treserva(
	id_reserva int not null  primary key,
	titulo varchar(100),-- el porque de la cita
	nota text,-- observacion
	mensaje text,-- mensaje o descripcion
	fecha_de_cita date,
	hora_de_cita time,
	precio double,
	esta_en_web boolean not null default false,
    creado_en datetime,
    estado varchar(30),
    pago varchar(30),
	id_medico int,
	id_usuario int,
    id_historia int,
    id_especialidad int,
	foreign key (id_usuario) references tusuario(id_usuario),
	foreign key (id_medico) references tmedico(id_medico),
    foreign key (id_historia) references thistoria(id_historia),
    foreign key (id_especialidad) references tespecialidad(id_especialidad)
);
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------
-- modificar todo
drop table if exists tatencion;
create table if not exists tatencion
(
	id_atencion int primary key,
	id_reserva int,
    id_triaje int,
    -- id_medico int,
    diagnostico text,
	hora_atencion time,
    -- foreign key (id_medico) references tmedico(id_medico),
    foreign key (id_triaje) references ttriaje(id_triaje),
    foreign key (id_reserva) references treserva(id_reserva)
);
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------------
drop table if exists treceta;
create table if not exists treceta
(
	id_receta int primary key,
    interno boolean,
    tiempo_tratamiento text,
    id_atencion int,
    foreign key (id_atencion) references tatencion(id_atencion)
);

drop table if exists tdet_receta;
create table if not exists tdet_receta
(
	id_det_receta int primary key,
	cantidad int,
	dosis text,
    frecuencia text, 
    id_medicamento int,
    id_receta int,
    foreign key (id_medicamento) references tmedicamento(id_medicamento),
    foreign key (id_receta) references treceta(id_receta)
);
-- drop table if exists tmodificado;
-- create table if not exists tmodificado
-- (
-- 	id_modificado int auto_increment primary key,
--     tabla_modificada varchar(20),
--     fecha datetime,
--     id_user int,
--     original text,
--     modificado text
-- );
-- drop table if exists tlogin;
-- create table if not exists tlogin
-- (
-- 	id_login int auto_increment primary key
-- creado_en date time
-- id_usuario int
-- );