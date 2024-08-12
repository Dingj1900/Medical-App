package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

@PreAuthorize("hasRole('PATIENT')") // rash

public class PatientController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private AppointmentDao appointmentDao;

    //Get all appointments for a patient
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/patient/appointments", method = RequestMethod.GET)
    public List<Appointment> getAppointments(Principal principal) {
        List<Appointment> patientAppointment = new ArrayList<>();

        int patientId = userDao.getUserByUsername(principal.getName()).getId(); // does it matter if it is userDAO or patientDAO?

        try {
            //get patient by id
            patientAppointment= patientDao.getAppointments(patientId);
        } catch (DaoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return patientAppointment;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/patient/office/{id}/provider")
    public User getDoctorByOfficeId(@PathVariable int officeId) {

        User user = new User();

         try {
            user = patientDao.getDoctorByOfficeId(officeId);
        } catch (DaoException error) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return user;
    }

    // Create a new appointment for a patient
    @PostMapping("/patient/appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public int createAppointment(@RequestBody Appointment appointment, Principal principal) {
        int newAppointment =0;
        try {
            // Retrieve the patient ID from the logged-in user
            User user = userDao.getUserByUsername(principal.getName());
            int patientId = user.getId();

            // Set the patient ID for the appointment
            appointment.setPatientId(patientId);

            // Add appointment to the database
            newAppointment = patientDao.createAppointment(appointment);

            // Return the newly created appointment


        } catch (DaoException e) {
            // Log the error and return an appropriate HTTP status
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create appointment", e);
        }
        return newAppointment;

    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/patient/provider/{id}/services", method = RequestMethod.GET)
    public List<Services> getServicesByDoctor(@PathVariable int id) {
        List<Services> patientOffices = new ArrayList<>();
        try {
            patientOffices = patientDao.getServicesByDoctor(id);
        } catch (DaoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return patientOffices;
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/patient/offices", method = RequestMethod.GET)
    public List<Office> getOffices() {
        List<Office> patientOffices = new ArrayList<>();
        try {
             patientOffices = patientDao.getOffices();
        } catch (DaoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return patientOffices;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path ="/patient/appointments", method = RequestMethod.GET)
    public List<AppointmentDto>getAppointment(Principal principal){
        List<AppointmentDto> patientAppointment= new ArrayList<>();

        try {
            patientAppointment= appointmentDao.getAppointments(userDao.getUserByUsername(principal.getName()).getId());
        }catch (DaoException error){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return patientAppointment;
    }



    //update an existing patient appointment
//    @RequestMapping(path = "/patient/appointment/{id}", method = RequestMethod.PUT)
//    public Appointment updatePatientAppointment(@PathVariable int id, Principal principal) {
//        Appointment newAppointment = null;
//
//        int patientId = userDao.getUserByUsername(principal.getName()).getId();
//
//        try {
//
//            //find appointment by id, if does not exist
//
//
//
//            //update appointment
//
//        } catch (DaoException error) {
//
//        }
//
//        return newAppointment;
//    }


}







