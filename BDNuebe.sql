
drop table sucursales;
drop table archivos_pre;
drop table trabajadores;


create table Materias(
`id` int primary key not null auto_increment,
`nombre` varchar(45) not null
);

drop table Calificaciones;
create table Calificaciones(
`id` int not null primary key auto_increment,
`mod1` float,
`mod2` float,
`mod3` float,
`idA` int not null,
`idM` int not null
);

set foreign_key_checks=1;
commit;
-- -------------------------
create table empleadosKumon(
`idE` int not null,
`idK` int not null,
primary key(`idE`,`idK`),
index `fk_idK_kumon_idx`(`idK` asc) visible,
constraint `fk_id_empleado`
foreign key(`idE`)
references `nube`.`usuarios`(`idUs`)
on delete no action
on update no action,
constraint `fk_id_kumon`
foreign key(`idK`)
references `nube`.`Kumon`(`id_Kumon`)
on delete no action
on update no action
);

set foreign_key_checks=1;
commit;
-- ----------creacion de la tabla pagos y alumnosPagos  17 sep 2022----------------------

create table pagos(
`id` int primary key auto_increment not null,
`fecha_p` date not null,
`monto_mensual` Float not null,
`monto_moratorio` float not null,
`monto_T` float not null
);
drop table alumnospagos;
create table alumnospagos(
`idAlumno1` int not null,
`idPago` int not null,
primary key(`idAlumno1`, `idPago`),
index `fk_id_pago_idx` (`idPago` asc) visible,
constraint `fk_id_alumno1`
	foreign key(`idAlumno1`)
	references `nube`.`alumnos`(`id_cliente`)
	on delete no action
	on update no action,
constraint `fk_id_pago`
	foreign key(`idPago`)
    references `nube`.`pagos`(`id`)
    on delete no action
    on update no action
);

set foreign_key_checks=1;
commit;
use nube;
drop table alumnos;
CREATE TABLE `alumnos` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `tutor` varchar(50) NOT NULL,
  `id_centro` int NOT NULL,
  `nom_sys_user` varchar(45) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `materia` int DEFAULT NULL,
  `pago` int DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  key `fk_materia_idx`(`materia`),
  constraint `fk_materia` foreign key (`materia`) references `materias`(`id`)
  /*,index`fk_pago_idx`(`pago` asc) visible,
  constraint `fx_pago`
    foreign key(`pago`)
    references `nube`.`pagos`(`id`)
    on delete no action
    on update no action*/
) ;
-- -------borrado de tables fuera de alcance 17 sep 2022-------------
use nube;
drop table empleadoskumon;
drop table kumon;
-- --------------------alter table pagos para agregar la propiedad de alumno 18 sep 2022---------------------
use nube;
Alter table pagos
Add alumno int not null;

Alter table materias
Add alumnos int not null;

insert into materias(nombre,alumnos) values ('aritmetica 1',0);
insert into materias(nombre,alumnos) values ('aritmetica 2',0);
insert into materias(nombre,alumnos) values ('Algebra',0);
insert into materias(nombre,alumnos) values ('trigonometria',0);
insert into materias(nombre,alumnos) values ('geometria analitica',0);
insert into materias(nombre,alumnos) values ('calculo diferencial',0);
insert into materias(nombre,alumnos) values ('calculo integral',0);
insert into materias(nombre,alumnos) values ('probabilidad',0);