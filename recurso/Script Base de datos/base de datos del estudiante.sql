create database EvaluacionPractica2;
 use EvaluacionPractica2;
	create table Estudiante(
		id_estudinte int primary key auto_increment not null,
		carnet_esudiante varchar(6) not null,
        nom_esudiante  varchar(30) not null,
        ape_esudiante  varchar(30) not null,
        edad int(3) not null
)ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1001 ;

