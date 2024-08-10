package com.techelevator.dao;


import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;

import java.util.List;

public interface DoctorDao {


    Office getOfficeByDoctor(int doctorId);

    Appointment getAppointmentByDoctor(int doctorId);

    List<Appointment> getAppointmentsByDoctor(int doctorId);

    Office updateOfficeById(Office office);

    int createOffice(Office office, int doctorId);


}
