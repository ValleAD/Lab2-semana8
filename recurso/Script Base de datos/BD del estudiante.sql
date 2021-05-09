create database lab2_semana8;

 	create table estudiante(
		id_estudiante int primary key auto_increment not null,
		carnet_estudiante varchar(6) not null,
        nom_estudiante  varchar(30) not null,
        ape_estudiante  varchar(30) not null,
        edad int(3) not null
)ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1001 ;
