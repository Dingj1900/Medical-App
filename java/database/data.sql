BEGIN TRANSACTION;

INSERT INTO users (user_id, username, password_hash, role, first_name, last_name, middle_initials, gender, phone_number,
email, date_of_birth, address, city, state_abbreviation, zip_code, hours_from, hours_to, is_monday, is_tuesday, is_wednesday,
 is_thursday, is_friday, is_saturday, is_sunday)
VALUES (1, 'trumanh', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PATIENT','Henry', 'Truman',
        'L','Male','419-266-0567','htru81@yahoo.com','1981-03-20','644 Sunnyside Dr', 'Toledo','OH','43612'),
       (2, 'menzav', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PATIENT', 'Vicky', 'Menza',
        'S', 'Female', '614-568-4497', 'catlover_28@gmail.com', '1962-05-31', '1063 Gumtree Ave', 'Lima', 'OH', '45801'),
       (3, 'torrancec', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PATIENT', 'Carter', 'Torrance',
        'B', 'Male', '508-784-9182', 'torrance.garden@hotmail.com', '1993-11-06', '732 Comet Cove Dr STE 113', 'Westerville', 'OH', '43081'),
       (4, 'carpenterm', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PATIENT', 'Melanie', 'Carpenter',
         'G', 'Female', '614-229-4127', 'mcarp27@gmail.com', '1974-09-15', '3161 Summit St', 'Westerville', 'OH', '43086'),
       (5, 'gleenerm', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PATIENT', 'Monica', 'Gleener',
         'D', 'Other', '780-422-6808', 'heyhey.monica@yahoo.com', '1998-10-09', '209 Tusla Dr', 'Worthington', 'OH', '43085'),
       (6, 'darrent', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PATIENT', 'Thomas', 'Darren',
         'W', 'Male', '619-535-2836', 't.darren76@gmail.com', '1976-08-14', '2172 Elmwood Ave', 'Lewis Center', 'OH', '43035'),
       (7, 'drsamsond', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PROVIDER', 'Derrick', 'Samson',
         'Male', '614-882-4937', 'drsamsond@hotmail.com', '08:00:00','17:00:00', 'true','true','true','true', 'false', 'false', 'false'),
       (8, 'drzhaoc', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PROVIDER', 'Cindy', 'Zhao',
         'Female', '567-488-2166', 'drzhaocindy@gmail.com', '1990-02-02', '08:00:00','16:00:00', 'true','true','true','true', 'true', 'false', 'false'),
       (9, 'drmulliganr', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PROVIDER', 'Rodney', 'Mulligan',
         'Male', '419-671-8326', 'rodney.mulligandr@gmail.com', '08:00:00','18:00:00', 'true','true','false','true', 'false', 'false', 'false'),
       (10, 'drkellogs', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_PROVIDER', 'Stacey', 'Kellog',
         'Female', '734-432-6968', 'dr.staceyk@gmail.com', '07:00:00','16:00:00', 'false','true','true','true', 'true', 'false', 'false');


INSERT INTO office(office_id, office_name, office_address, phone_number, hours_from, hours_to)
VALUES(100 ,'Premier Health Center','115 West Bridge Rd, Worthington, OH 43229','784-824-4637','08:00:00','17:00:00'),
      (110 ,'TrustCare Medical Group','161 Kinnear Rd STE 17, Columbus, OH 43212','614-980-3842','08:00:00','16:00:00'),
      (120 ,'ProHealth Clinic','38 Findley Dr, Toledo, OH 43623','419-801-3824','08:00:00','18:00:00'),
      (130 ,'Genesis Wellness Associates','423 N. Park Ave, Upper Arlington, OH 43220','614-583-5003','07:00:00','16:00:00');

INSERT INTO services(service_id, service_name, service_details, hourly_rate, doctor_id)
VALUES (1, 'Wellness Physical', 'During this visit, we review your medical and family history, health habits, and perform a physical exam and recommend additional screenings if needed.', 190.00, 10),
       (2, 'Office Visit', 'Ideal for addressing 1-3 specific topics. For complex issues, a follow-up visit maybe necessary to ensure through care.', 75.00, 10),
       (3, 'Pre-Travel Consultation', 'We will review your travel needs and secure prescription approvals, with a physician confirming recommendations. Some insurance plans do not cover these appointments.', 60.00, 10),
       (4, 'Problem-Only Visit', 'During problem-only visits, only one complaint or problem will be addressed, with no discussion of chronic issues, medication refills, or routine labs.', 86.00, 9),
       (5, 'Follow-Up', 'Patients on maintenance medications must see their primary care physician regularly for refills, with follow-up visits typically scheduled before leaving the office.', 70.00, 9),
       (6, 'Wellness Physical', 'Screens health risks with a questionnaire, brief exam, and minimal lab work, but does not address existing conditions or complaints.', 155.00, 9),
       (7, 'Office Visit', 'Focusing on a few specific issues. A follow-up visit may be needed to ensure comprehensive attention and resolution for more complex concerns.', 80.00, 7),
       (8, 'Follow-Up', 'To continue receiving refills for maintenance medications, patients must have routine check-ins with their primary care physician.', 60.00, 7),
       (9, 'Vaccinations', 'We offer the influenza vaccine from September to April and provide the TDAP vaccine when needed. For other vaccines, please contact your local pharmacy.', 180.00, 7),
       (10, 'Vaccinations', 'We provide influenza vaccine and administer the TDAP vaccine as required. Additionally, we offer HPV, hepatitis B, and pneumococcal vaccines in our office.', 230.00, 8),
       (11, 'Problem-Only Visit', 'We address a single complaint or issue during problem-only visits and do not cover chronic conditions, routine lab work, or medication refills.', 90.00, 8),
       (12, 'Blood Work', 'For fasting tests, you can schedule a dedicated blood-draw appointment at 8 a.m., but only if you have seen one of our physicians previously.', 315.00, 8),;

INSERT INTO appointment(appointment_id, service_id, office_id, patient_id, doctor_id, appt_date, is_notified, is_approved)
VALUES (50, 1, 130, 4, 10,'20240903 09:00:00', 'true', 'true'),
       (51, 3, 130,  6, 10,'20240926 13:00:00', 'false', 'true'),
       (52, 9, 100, 4, 7,'20241024 16:00:00', 'false', 'true'),
       (53, 7, 100,  3, 7,'20240826 14:00:00', 'false', 'false'),
       (54, 10, 110,  6, 8,'20240829 10:00:00', 'true', 'true'),
       (55, 12, 110,  6, 8,'20241112 08:00:00', 'false', 'true'),
       (56, 11, 110,  5, 8,'20240819 15:00:00', 'true', 'false'),
       ;


INSERT INTO doctor_office(doctor_id, office_id)
VALUES (7, 100),
       (8, 110),
       (9, 120),
       (10, 130);

COMMIT TRANSACTION;