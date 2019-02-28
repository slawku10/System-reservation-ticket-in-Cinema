create table user(
	id			int not null auto_increment,
	username 	varchar(20) not null,
	password 	char(20) not null,
    email		varchar(50) not null,
    role		enum('employee', 'usernotEmployee'),
    
    primary key(id)
);

create table hall(
	id			int not null auto_increment,
	numOfPlaces	int not null,
    
    primary key(id)
);

create table film(
	id			int not null auto_increment,
    name		varchar(30) not null,
    type		varchar(30),
    duration	int,
    
    primary key(id)
);

create table showing(
	id			int not null auto_increment,
    dateStart	date not null,
    dateEnd		date not null,
    
    id_hall		int not null,
    id_film 	int not null,
    
    primary key(id),
    constraint fk_showing_hall foreign key (id_hall) references hall(id),
    constraint fk_showing_film foreign key (id_film) references film(id)
);

create table reservation(
	showingid			int not null auto_increment,
    place		int not null,
    placeKind	enum('normalny', 'ulgowy'),
    status		enum('rezerwacja', 'bilet'),
    price		double not null,
	
    id_user		int not null,
    id_showing	int not null,

    primary key(id),
    constraint fk_reservation_user foreign key (id_user) references user(id),
    constraint fk_reservation_showing foreign key (id_showing) references showing(id)
);