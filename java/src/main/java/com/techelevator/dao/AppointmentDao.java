package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDto;

import java.util.List;

public interface AppointmentDao {
    List<AppointmentDto>getAppointments(int patientId);

    //int createAppointment(Appointment appointment,int patientId);


}
