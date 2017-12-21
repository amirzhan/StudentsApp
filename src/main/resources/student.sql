
CREATE TABLE education_history (
	education_history_id SERIAL,
	student_id int NOT NULL,
	educated_place_name varchar(250) DEFAULT NULL,
	during_time varchar(45) DEFAULT NULL,
	address varchar(250) DEFAULT NULL,
	PRIMARY KEY(education_history_id),
	FOREIGN KEY(student_id) REFERENCES users(user_id)
);

CREATE TABLE users (
	user_id SERIAL,
	role_id int NOT NULL,
	specialty_id int DEFAULT NULL,
	username varchar(45) NOT NULL UNIQUE,
	password varchar(45) NOT NULL,
	first_name varchar(45) DEFAULT NULL,
	last_name varchar(45) DEFAULT NULL,
	PRIMARY KEY(user_id),
	FOREIGN KEY (role_id) REFERENCES  roles(role_id),
	FOREIGN KEY(specialty_id) REFERENCES specialty(specialty_id)
);
CREATE TABLE specialty (
	specialty_id SERIAL,
	faculty_id int NOT NULL,
	specialty_name varchar(45) NOT NULL UNIQUE,
	PRIMARY KEY(specialty_id),
	FOREIGN KEY(faculty_id) REFERENCES faculty(faculty_id)
);

CREATE TABLE faculty (
	faculty_id SERIAL,
	faculty_name varchar(45) NOT NULL UNIQUE,
	PRIMARY KEY(faculty_id)
);
CREATE TABLE roles (
	role_id SERIAL,
	role_name varchar(45) NOT NULL,
	PRIMARY KEY (role_id)
);
drop table education_history, users, specialty, faculty, roles cascade;

INSERT INTO roles VALUES(1,'ADMIN'),(2,'USER');

INSERT INTO users(user_id,role_id,username,password,first_name,last_name) VALUES(1,1,'admin','admin','Admin','Adminuly');


INSERT INTO faculty VALUES (2,'ECO'),(1,'Engineering'),(3,'LOW'),(4,'Philo');
INSERT INTO specialty VALUES (11,1,'Information System'),(12,1,'Software Engineer'),(13,1,'Hardword Engineer'),(14,2,'Local Economy'),(15,2,'Global Economy'),(16,3,'Kazakhstan Low'),(17,3,'International Low '),(18,4,'Turik culture ');




