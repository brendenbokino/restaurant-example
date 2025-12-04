create table reservation (
        id_reservation int not null auto_increment,
        dt_reservation datetime not null,
        status_reservation varchar(20) not null,
        num_guests int not null,
        constraint reservation_pk primary key (id_reservation)
);
