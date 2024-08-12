BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, roles, userRole CASCADE;

DROP TABLE IF EXISTS office ,appointment, medication,time_period, prescription,
doctor_services,services,review,doctor_office CASCADE;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

--	CONSTRAINT PK_user PRIMARY KEY (user_id)
--MEDICAL APP TABLES FROM PG-ADMIN >>>>
--CREATE TABLE users(

	first_name varchar(20),
	last_name varchar(20),
	middle_initials varchar(2),
	gender varchar(10),
	phone_number varchar(20),
	email varchar (50),
	date_of_birth date,
	address varchar(100) ,
	city varchar(50),
	state_abbreviation varchar(2) ,
	zip_code varchar (5),
	hours_from time,
    hours_to time,
	is_monday boolean,
    is_tuesday boolean,
    is_wednesday boolean,
    is_thursday boolean,
    is_friday boolean,
    is_saturday boolean,
    is_sunday boolean,

    CONSTRAINT pk_user PRIMARY KEY (user_id),
	CONSTRAINT gender_check CHECK (gender IN ('Male', 'Female', 'Other')),
	CONSTRAINT state_abbreviation_check CHECK (state_abbreviation IN ('AL',  'AK ',  'AZ', 'AR', 'CA',  'CO',  'CT',  'DE',  'FL', 'GA', 'HI', 'ID', 'IL',  'IN', 'IA',  'KS',  'KY',
																	  'LA',  'ME', 'MD', 'MA', 'MI', 'MN', 'MS',  'MO', 'MT', 'NE', 'NV', 'NH' , 'NJ', 'NM' , 'NY', 'NC', 'ND', 'OH',
																	  'OK', 'MN', 'MS',  'MO', 'MT', 'NE', 'NV', 'NH',  'NJ',  'NM',  'NY',  'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI',
																	  'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'))
);


CREATE TABLE office(
	office_id SERIAL,
	office_name varchar (50),
	office_address varchar (100),
	phone_number varchar (20) NOT NULL,
	hours_from time,
	hours_to time,


	CONSTRAINT pk_office PRIMARY KEY (office_id)


);


CREATE TABLE doctor_office(
doctor_id int NOT NULL,
office_id int NOT NULL,

CONSTRAINT fk_users FOREIGN KEY (doctor_id)REFERENCES users(user_id),
CONSTRAINT fk_office FOREIGN KEY (office_id)REFERENCES office(office_id),
CONSTRAINT pk_doctor_offices PRIMARY KEY(doctor_id,office_id)

);

CREATE TABLE services(
	service_id Serial,
	service_name varchar(50) NOT NULL,
	service_details varchar(200)NOT NULL,
	hourly_rate numeric(9,2) NOT NULL,
	doctor_id int,

	CONSTRAINT pk_services_id PRIMARY KEY (service_id),
	CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id)REFERENCES users(user_id)

);


CREATE TABLE appointment(
	appointment_id SERIAL,
	service_id int NOT NULL,
	office_id int NOT NULL,
	patient_id int NOT NULL,
	doctor_id int NOT NULL,
	appt_date timestamp NOT NULL,
	is_notified boolean,
	is_approved boolean,

	CONSTRAINT pk_appointment PRIMARY KEY(appointment_id),
	CONSTRAINT fk_service_id FOREIGN KEY(service_id)REFERENCES services(service_id),
	CONSTRAINT fk_office FOREIGN KEY(office_id)REFERENCES office(office_id),
	CONSTRAINT fk_patient_id FOREIGN KEY(patient_id)REFERENCES users(user_id),
	CONSTRAINT fk_doctor_id FOREIGN KEY(doctor_id)REFERENCES users(user_id)

);


CREATE TABLE time_period(
	period_id serial,
	start_date date NOT NULL,
	end_date date NOT NULL,

	CONSTRAINT pk_period PRIMARY KEY (period_id)
);


CREATE TABLE medication(
	medication_id serial,
	medication_name varchar(50) NOT NULL,
	description varchar(200) NOT NULL,
	dosage varchar(100) NOT NULL,

	CONSTRAINT pk_medication PRIMARY KEY (medication_id)
);


CREATE TABLE prescription(
	doctor_id int,
	patient_id int,
	medication_id int,
	period_id int,

	CONSTRAINT pk_prescription PRIMARY KEY (doctor_id, patient_id, medication_id, period_id),

	CONSTRAINT fk_time_period FOREIGN KEY (period_id)REFERENCES time_period(period_id),
	CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id),
	CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES users(user_id),
	CONSTRAINT fk_medication FOREIGN KEY (medication_id)REFERENCES medication(medication_id)
);


 CREATE TABLE review(
	 patient_id int ,
	 doctor_id int ,
	 patient_review varchar(200) NULL,
	 doctor_response varchar(200) NOT NULL,

	 CONSTRAINT pk_review PRIMARY KEY (patient_id, doctor_id),

	 CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES users(user_id),
	 CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES users(user_id)

 );

COMMIT TRANSACTION;
