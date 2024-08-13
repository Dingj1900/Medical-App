package com.techelevator.dao;


import com.techelevator.model.*;

import java.util.List;

public interface DoctorDao {

    Office getOfficeByDoctor(int doctorId); //good

//    Appointment getAppointmentByDoctor(int doctorId);


    Office updateOfficeById(Office office); //good

    int createDoctorOffice(Office office, int doctorId); //good

    List<Services> getServicesByDoctor(int doctorId);

    Services updateServiceById(Services services);

    int createService(Services services, int doctorId);


    //    Services getServiceByService(int serviceId);

}
