package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PatientController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/patient/register", method = RequestMethod.POST)
    public Patient createPatientForUser(@RequestBody Patient patient){

        Patient createdPatient = null;

        try{

            //create dao for adding a patient object

        }catch(DaoException error){

        }

        return patient;
    }

    @RequestMapping(path = "/patient/appointments", method = RequestMethod.GET)
    public List<Patient> getPatientAppointments(Principal principal){
        List<Patient> patientList = new ArrayList<>();

        try{

            //get patient by user Id

            //loop through appointments where patientId are the same;

        }catch(DaoException error){

        }

        return patientList;
    }

    @RequestMapping(path = "/patient/appointment", method = RequestMethod.POST)
    public Appointment createPatientAppointment(@RequestBody Appointment appointment){
        Appointment newAppointment = null;

        try{
            //add appointment to database;

        }catch(DaoException error){

        }

        return newAppointment;

    }

//    @RequestMapping(path ="", method = RequestMethod.PUT)
}
