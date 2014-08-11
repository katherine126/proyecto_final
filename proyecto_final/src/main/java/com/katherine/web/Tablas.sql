CREATE TABLE libro(id_libro integer primary key auto_increment, 
titulo varchar(80), 
autor varchar(80), 
editorial varchar(80), 
foreign key(id_autor) references autor(id_autor), 

CREATE TABLE autor(id_autor integer primary key auto_increment, 
nombre varchar(80), 
apellidoPa varchar(80), 
apellidoMa varchar(80),
foreign key(id_editorial) references editorial(id_editorial));

CREATE TABLE editorial(id_editorial integer primary key auto_increment, 
nombre varchar(80), 
direccion varchar(80), 
telefono varchar(80));