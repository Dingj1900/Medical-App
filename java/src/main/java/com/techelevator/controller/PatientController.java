package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.DatagramPacket;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PatientController {

    @Autowired
    private UserDao userDao;

    //create a patient after login in Authentication Controller
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/patient/register", method = RequestMethod.POST)
    public Patient createPatientForUser(@RequestBody Patient patient, Principal principal){

        Patient createdPatient = null;

        int patientId = userDao.getUserByUsername(principal.getName()).getId();

        try{

            //create dao for adding a patient object

        }catch(DaoException error){

        }

        return createdPatient;
    }

    //get a single patient based off user
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/patient", method = RequestMethod.GET)
    public Patient getPatientById(Principal principal) {

        Patient patient = null;

        int patientId = userDao.getUserByUsername(principal.getName()).getId();

        try{

            //get patient by id

            //loop through appointments where patientId are the same;

        }catch(DaoException error){

        }

        return patient;
    }



    //Get all appointments for a patient
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/patient/appointments", method = RequestMethod.GET)
    public List<Patient> getPatientAppointments(Principal principal){
        List<Patient> patientList = new ArrayList<>();

        int patientId = userDao.getUserByUsername(principal.getName()).getId();

        try{

            //get patient by id

            //loop through appointments where patientId are the same;

        }catch(DaoException error){

        }

        return patientList;
    }

    //create a new appointment for a patient
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/patient/appointment", method = RequestMethod.POST)
    public Appointment createPatientAppointment(@RequestBody Appointment appointment, Principal principal){
        Appointment newAppointment = null;

        int patientId = userDao.getUserByUsername(principal.getName()).getId();


        try{
            //add appointment to database;

        }catch(DaoException error){

        }

        return newAppointment;

    }

    //update an existing patient appointment
    @RequestMapping(path = "/patient/appointment/{id}", method = RequestMethod.PUT)
    public Appointment updatePatientAppointment(@PathVariable int id,Principal principal){
        Appointment newAppointment = null;

        int patientId = userDao.getUserByUsername(principal.getName()).getId();

        try{
            //find appointment by id, if does not exist

            //update appointment

        }catch(DaoException error){

        }

        return newAppointment;
    }

    //delete a existing patient appointment
    @RequestMapping(path = "/patient/appointment/{id}", method = RequestMethod.DELETE)
    public void deletePatientAppointment(@PathVariable int id){
        Appointment newAppointment = null;

        try{
            //find appointment by id, if does not exist

            //update appointment

        }catch(DaoException error){

        }

    }

}






