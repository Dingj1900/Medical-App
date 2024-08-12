package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {
    List<Appointment>getAppointments();

    Appointment getAppointmentById(int id);





}
