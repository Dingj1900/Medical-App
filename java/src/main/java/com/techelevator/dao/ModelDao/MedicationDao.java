package com.techelevator.dao.ModelDao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Medication;

import java.util.List;

public interface MedicationDao {
    Medication getMedicationById (int medication);
    Medication createMedication(Medication medication);
    boolean updateMedication(Medication medication);

    List<Medication>getAllMedication();



//    Appointment getAppointmentById (int appointmentId);
//    Appointment createAppointment(Appointment appointment);
//    boolean updateAppointment(Appointment appointment);
//    boolean deleteAppointment(int id);
//
//    List<Appointment> getAllAppointments();  // list of  all appointments

}
