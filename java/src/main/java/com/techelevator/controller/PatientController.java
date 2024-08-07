package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Patient;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.DatagramPacket;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PatientController {

    @Autowired
    private UserDao userDao;

    //get a single patient based off user
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/patient", method = RequestMethod.GET)
    public User getPatientById(Principal principal) {

        User patient = null;

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
    public List<User> getPatientAppointments(Principal principal){
        List<User> patientList = new ArrayList<>();

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
            //throw new ResponseStatusException();
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






