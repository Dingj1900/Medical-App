package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import com.techelevator.model.Patient;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.Doc;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("hasRole('Doctor')")
public class DoctorController {

    @Autowired
    private UserDao userDao;


//    @RequestMapping(path = "/doctor/register", method = RequestMethod.POST)
//    public Doctor createDoctorForUser(@RequestBody Doctor doctor, Principal principal){
//        Doctor newDoctor = null;
//        int doctorId = userDao.getUserByUsername(principal.getName()).getId();
//
//        try{
//            if (userDao.getUserById(doctorId) != null) {
//                throw new DaoException("Doctor already exists for this user");
//            }
//            doctor.setDoctorId(doctorId);
//            newDoctor = userDao.createUser(Doctor);
//
//            //check if doctorId exist in doctor table, if so throw error
//
//            //add doctor with user_id
//
//            // once the JDBC is done, replace comments with JDBC method
//
//        }catch(DaoException error){
//            System.out.println("Error creating user" + error.getMessage());
//            throw new RuntimeException("Failed to create Doctor", error);
//        }
//
//        return newDoctor;
//    }

    @GetMapping(path = "/doctor/office")
    public Office getOfficeForDoctor(Principal principal){
        Office office = null;
        int doctorId = userDao.getUserByUsername(principal.getName()).getId(); // get the ID for this specific user (who is a Dr)

        try{
            // returns office for doctor, takes in Doctor ID - this is where the JDBC will cover
        } catch(DaoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return office;
    }

    @GetMapping(path= "/doctor/appointments")
    public Doctor getAllAppointments(@RequestBody Doctor doctor, Principal principal) {

    }






}
