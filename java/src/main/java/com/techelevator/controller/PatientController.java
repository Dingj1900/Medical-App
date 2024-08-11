package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.User;
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

@PreAuthorize("hasRole('Patient')") // rash

public class PatientController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PatientDao patientDao;

    //Get all appointments for a patient
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/patient/appointments", method = RequestMethod.GET)
    public List<Appointment> getPatientAppointments(Principal principal) {
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


    // Create a new appointment for a patient
    @PostMapping("/patient/appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public int createPatientAppointment(@RequestBody Appointment appointment, Principal principal) {
        int newAppointment =0;
        try {
            // Retrieve the patient ID from the logged-in user
            User user = userDao.getUserByUsername(principal.getName());
            int patientId = user.getId();

            // Set the patient ID for the appointment
            appointment.setPatientId(patientId);

            // Add appointment to the database
            newAppointment = patientDao.createAppointment(appointment, patientId);

            // Return the newly created appointment


        } catch (DaoException e) {
            // Log the error and return an appropriate HTTP status
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create appointment", e);
        }
        return newAppointment;

    }


//    // Create a new appointment for a patient
//    @PostMapping("/appointment")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Appointment createAppointment(@RequestBody Appointment appointment, Principal principal) {
//        try {
//            User user = userDao.getUserByUsername(principal.getName());
//            appointment.setPatientId(user.getId());
//            return patientDao.createAppointment(appointment, principal);
//        } catch (DaoException e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create appointment", e);
//        }
//    }


    //update an existing patient appointment
    @RequestMapping(path = "/patient/appointment/{id}", method = RequestMethod.PUT)
    public Appointment updatePatientAppointment(@PathVariable int id, Principal principal) {
        Appointment newAppointment = null;

        int patientId = userDao.getUserByUsername(principal.getName()).getId();

        try {

            //find appointment by id, if does not exist



            //update appointment

        } catch (DaoException error) {

        }

        return newAppointment;
    }

//    //delete a existing patient appointment
//    @RequestMapping(path = "/patient/appointment/{id}", method = RequestMethod.DELETE)
//    public void deletePatientAppointment(@PathVariable int id){
//        Appointment newAppointment = null;
//
//        try{
//            //find appointment by id, if does not exist
//
//            //update appointment
//
//        }catch(DaoException error){
//
//        }
//        return newAppointment;
//
//    }

    //view list of all offices
    //view list of all doctors
    //return doctor office - combining a class/array to return two objects


    //get doctor by office id


    //view list of all doctors


    //get offices by office id


    //get services by doctor


}








