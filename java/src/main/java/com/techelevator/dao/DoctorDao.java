package com.techelevator.dao;


import com.techelevator.model.*;

import java.util.List;

public interface DoctorDao {

    Office getOfficeByDoctor(int doctorId); //good

    Appointment getAppointmentByDoctor(int doctorId);

    List<Appointment> getAppointmentsByDoctor(int doctorId); //good

    Office updateOfficeById(Office office);

    int createOffice(Office office, int doctorId);

    List<Services> getServicesByDoctor(int doctorId);

    Services updateServiceById(Services services);

    int createService(Services services, int doctorId);


    //    Services getServiceByService(int serviceId);

}
