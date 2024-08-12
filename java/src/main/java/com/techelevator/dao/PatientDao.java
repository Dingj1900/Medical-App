package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.Services;
import com.techelevator.model.User;

import java.util.List;

public interface PatientDao {


    User getDoctorByOfficeId(int officeId);

    //List<Appointment> getAppointments(int patientId);

    int createAppointment(Appointment appointment);

    List<Office> getOffices();

    List<Services> getServicesByDoctor(int doctorId);



}
