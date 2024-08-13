BEGIN TRANSACTION;

INSERT INTO users (user_id, username, password_hash, role, first_name, last_name, middle_initials, gender, phone_number,
email, date_of_birth, address, city, state_abbreviation, zip_code, hours_from, hours_to, is_monday, is_tuesday, is_wednesday,
 is_thursday, is_friday, is_saturday, is_sunday)
VALUES (1, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER','Rash', 'Hour', 'RH','Male','614','rh@yahoo.com','2020-01-01','111 street',
        'westerville','OH','43081','10:00:00','18:00:00','true','true','true','true',
        'true', 'true', 'false'),
       (12, 'user123', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_ADMIN', 'Doctor', 'Glover',
        'k', 'Female', '419222', 'doc@gmail.com', '1990-02-02', '123 sunny st', 'Lima', 'OH', '45801', '10:00:00','18:00:00',
        'false','true','false','true', 'false', 'true', 'false'),
       (113, 'sowah', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PROVIDER', 'Doctor', 'Glover',
        'k', 'Female', '419222', 'doc@gmail.com', '1990-02-02', '123 sunny st', 'Lima', 'OH', '45801', '10:00:00','18:00:00',
        'false','true','false','true', 'false', 'true', 'false'),
       (98, 'Ding', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PATIENT', 'Ding', 'Glover',
         'k', 'Female', '419222', 'doc@gmail.com', '1990-02-02', '123 sunny st', 'Lima', 'OH', '45801', '10:00:00','18:00:00',
         'false','true','false','true', 'false', 'true', 'false');



INSERT INTO office(office_id, office_name, office_address, phone_number, hours_from, hours_to)
VALUES(111 ,'keelys office','111 Kinnear road','614','10:00:00','18:00:00'),
      (12  ,'COPC','111 Park Ave','614-980-3842','08:00:00','16:00:00'),
      (112 ,'Ohio State Medical','111 Kenny road','419-801-3824','09:00:00','17:00:00');

INSERT INTO services(service_name, service_details, hourly_rate, doctor_id)
VALUES ( 'help', 'my arm literally fell off', 1.2, 113),
       ( 'Check up', 'Need a COVID shot', 100, 113),
       ( 'Well Visit', 'School physical', 160, 113);

INSERT INTO appointment(appointment_id, service_id, office_id, patient_id, doctor_id, appt_date, is_notified, is_approved)
VALUES (121, 1, 111, 98, 113,'20240922 09:00:00', 'true', 'true'),
       (124, 2, 12,  98, 113,'20240922 09:00:00', 'false', 'false'),
       (131, 3, 112, 98, 113,'20240922 09:00:00', 'true', 'true');


COMMIT TRANSACTION;