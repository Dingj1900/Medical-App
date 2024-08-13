package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface PatientDao {


    User getDoctorByOfficeId(int officeId);

    //List<Appointment> getAppointments(int patientId);


    List<Office> getOffices();

    List<Services> getServices();

    public List<ServiceDto> getServiceInfoByName(String serviceName);



}
