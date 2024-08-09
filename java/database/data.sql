BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,first_name,last_name,middle_initials,gender,phone_number,
email,date_of_birth,address,city,state_abbreviation,zip_code,hours_from,hours_to,is_monday,is_tuesday,is_wednesday,
 is_thursday,is_friday,is_saturday,is_sunday)

VALUES ('user',
    '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',
    'ROLE_USER','Rash','Hour','RH','Male','614','rh@yahoo.com','2020-01-01','111 street',
    'westerville','OH','43081','10:00:00','18:00:00','true','true','true','true',
    'true', 'true', 'false');


INSERT INTO office(office_id,office_name,office_address,phone_number,hours_from,hours_to,day_from,day_to)

VALUES('111','HealMeNow','111 kinnear road','614','10:00:00','18:00:00','Monday','Sunday');




INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;
