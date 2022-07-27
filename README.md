Простоe приложение со Spring Security




БД для приложения - 

CREATE TABLE users
(
    username varchar(15),
    password varchar(100),
    enabled  tinyint(1),
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  varchar(15),
    authority varchar(25),
    FOREIGN KEY (username) references users (username)
);

insert into my_db.users (username, password, enabled)
values ('admin', '{bcrypt}$2y$10$mfobAWMYKrJrbZLs88DE4.3.4SwnNrf1BF1OjLhLZdp.VhsWX0L3u', 1),
       ('user', '{noop}user', 1),
       ('boss', '{noop}boss', 1);

insert into my_db.authorities (username, authority)
values ('user', 'ROLE_USER'),
       ('boss', 'ROLE_BOSS'),
       ('admin', 'ROLE_BOSS'),
       ('admin', 'ROLE_ADMIN');
