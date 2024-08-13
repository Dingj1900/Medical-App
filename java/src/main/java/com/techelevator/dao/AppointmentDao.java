package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentDto;

import java.util.List;

public interface AppointmentDao {
    List<AppointmentDto> getAppointmentsByPatientId(int patientId);
    List<AppointmentDto> getAppointmentsByDoctorId(int doctorId);

    Appointment createAppointment(Appointment appointment);

}
