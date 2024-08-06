BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, role, userRole CASCADE;

DROP TABLE IF EXISTS patient,doctor,office ,appointment, medication,time_period, prescription,
doctor_services,services,review CASCADE ;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE role(
role_id SERIAL,
role varchar(20) NOT NULL,

CONSTRAINT pk_role PRIMARY KEY (role_id)
);

CREATE TABLE userRole(
user_id int,
role_id int,

CONSTRAINT pk_userRole PRIMARY KEY (user_id, role_id),

CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES role (role_id)

);

--MEDICAL APP TABLES FROM PG-ADMIN >>>>

CREATE TABLE patient(
	patient_id SERIAL,
	first_name varchar (20) NOT NULL,
	last_name varchar(20)NOT NULL,
	middle_initials varchar(2) NULL,
	gender varchar(10) NOT NULL,
	phone_number varchar(20) NOT NULL,
	email varchar (50) UNIQUE,
	date_of_birth date NOT NULL,
	patient_address varchar(100) NOT NULL,
	city varchar(50) NOT NULL,
	state_abbreviation varchar(2) NOT NULL,
	zip_code varchar (5) NOT NULL,

    CONSTRAINT  pk_patient PRIMARY KEY (patient_id),
	CONSTRAINT gender_check CHECK (gender IN ('Male', 'Female', 'Others')),
	CONSTRAINT state_abbreviation_check CHECK (state_abbreviation IN ('AL',  'AK ',  'AZ', 'AR', 'CA',  'CO',  'CT',  'DE',  'FL', 'GA', 'HI', 'ID', 'IL',  'IN', 'IA',  'KS',  'KY',
																	  'LA',  'ME', 'MD', 'MA', 'MI', 'MN', 'MS',  'MO', 'MT', 'NE', 'NV', 'NH' , 'NJ', 'NM' , 'NY', 'NC', 'ND', 'OH',
																	  'OK', 'MN', 'MS',  'MO', 'MT', 'NE', 'NV', 'NH',  'NJ',  'NM',  'NY',  'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI',
																	  'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'))

);

CREATE TABLE doctor (
	doctor_id SERIAL,
	first_name varchar (20) NOT NULL,
	last_name varchar (20) NOT NULL,
	gender varchar (20) NOT NULL,
	hourly_rate money NOT NULL,
	phone_number varchar(20) NOT NULL,
	email varchar (50) UNIQUE,
	hours_from time NOT NULL,
	hours_to time NOT NULL,
	is_monday boolean,
	is_tuesday boolean,
	is_wednesday boolean,
	is_thursday boolean,
	is_friday boolean,
	is_saturday boolean,
	is_sunday boolean,

	CONSTRAINT pk_doctor PRIMARY KEY (doctor_id),
	CONSTRAINT gender_check CHECK (gender IN ('Male', 'Female', 'Others'))

);


CREATE TABLE office(
	office_id SERIAL,
	office_address varchar (100),
	phone_number varchar (20) NOT NULL,
	hours_from time NOT NULL,
	hours_to time NOT NULL,
	day_from varchar(10) NOT NULL,
	day_to varchar(10) NOT NULL,
	doctor_id int NOT NULL,


	CONSTRAINT pk_office PRIMARY KEY (office_id),
	CONSTRAINT fk_doctor FOREIGN KEY(doctor_id)REFERENCES doctor(doctor_id),

	CONSTRAINT day_from_check CHECK (day_from IN ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday',
												  'Saturday', 'Sunday')),
	CONSTRAINT day_to_check CHECK (day_to IN ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday',
												  'Saturday', 'Sunday'))

);


CREATE TABLE appointment(
	appointment_id SERIAL,
	office_id int NOT NULL,
	patient_id int NOT NULL,
	doctor_id int NOT NULL,
	appt_from timestamp NOT NULL,
	appt_to timestamp NOT NULL,
	is_notified boolean,
	is_approved boolean,

	CONSTRAINT pk_appointment PRIMARY KEY(appointment_id),
	CONSTRAINT fk_office FOREIGN KEY(office_id)REFERENCES office(office_id),
	CONSTRAINT fk_patient FOREIGN KEY(patient_id)REFERENCES patient(patient_id),
	CONSTRAINT fk_doctor FOREIGN KEY(doctor_id)REFERENCES doctor(doctor_id)

);


-- -- Association Table
-- CREATE TABLE calendar (
-- 	doctor_id NOT NULL,
-- 	appointment_id NOT NULL,

-- 	CONSTRAINT fk_doctor FOREIGN KEY(doctor_id)REFERENCES doctor(doctor_id),
-- 	CONSTRAINT fk_appointment FOREIGN KEY (appointment_id)REFERENCES appointment(appointment_id),
-- 	CONSTRAINT pk_calendar PRIMARY(doctor_id, appointment_id),

-- );

CREATE TABLE time_period(
	period_id SERIAL,
	start_date date NOT NULL,
	end_date date NOT NULL,

	CONSTRAINT pk_period PRIMARY KEY (period_id)
);


CREATE TABLE medication(
	medication_id serial,
	medication_name varchar (50) NOT NULL,
	description varchar (200) NOT NULL,
	dosage varchar (100) NOT NULL,

	CONSTRAINT pk_medication PRIMARY KEY (medication_id)
);


CREATE TABLE prescription(
	doctor_id int,
	patient_id int,
	medication_id int,
	period_id int,

	CONSTRAINT pk_prescription PRIMARY KEY (doctor_id, patient_id, medication_id, period_id),

	CONSTRAINT fk_time_period FOREIGN KEY (period_id)REFERENCES time_period(period_id),
	CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
	CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
	CONSTRAINT fk_medication FOREIGN KEY (medication_id)REFERENCES medication(medication_id)
);


CREATE TABLE services(
	service_id Serial,
	service_name varchar (50) NOT NULL,
	service_details varchar(200)NOT NULL,

	CONSTRAINT pk_services PRIMARY KEY (service_id)

);

 CREATE TABLE doctor_services(
  doctor_id int NOT NULL,
  service_id int NOT NULL,

	CONSTRAINT fk_services FOREIGN KEY(service_id)REFERENCES services(service_id),
	CONSTRAINT fk_doctor FOREIGN KEY (doctor_id)REFERENCES doctor(doctor_id),
	CONSTRAINT pk_doctor_services PRIMARY KEY(doctor_id, service_id)

 );

 CREATE TABLE review(
	 patient_id int ,
	 doctor_id int ,
	 patient_review varchar(200) NULL,
	 doctor_response varchar(200) NOT NULL,

	 CONSTRAINT pk_review PRIMARY KEY (patient_id, doctor_id),

	 CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
	 CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient(patient_id)

 );

COMMIT TRANSACTION;
