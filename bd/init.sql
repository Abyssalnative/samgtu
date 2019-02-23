create table teacher (
id SERIAL,
first_name varchar NOT NULL,
last_name varchar NOT NULL,
PRIMARY KEY (id)
);

create table lesson(
id SERIAL,
name varchar NOT NULL,
type varchar NOT NULL,
teacher_id int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (teacher_id) REFERENCES teacher (id)
);

create table schedule (
id SERIAL,
even boolean NOT NULL,
lesson_id int NOT NULL,
pair_order int NOT NULL,
day int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (lesson_id) REFERENCES teacher (id)
);