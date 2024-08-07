package com.techelevator.dao.ModelDao;

import com.techelevator.model.Appointment;
import java.util.List;

public interface AppointmentDao {
    Appointment getAppointmentById (int appointmentId);
    Appointment createAppointment(Appointment appointment);
    boolean updateAppointment(Appointment appointment);
    boolean deleteAppointment(int id);

    List<Appointment> getAllAppointments();  // list of  all appointments

}
