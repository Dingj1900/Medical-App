package com.techelevator.controller;

import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("hasRole('Doctor')")
public class DoctorController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DoctorDao doctorDao;


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
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/provider/office")
    public Office getOfficeForDoctor(Principal principal){
        Office office = null;
        int doctorId = userDao.getUserByUsername(principal.getName()).getId(); // get the ID for this specific user (who is a Dr)

        try{
            office = doctorDao.getOfficeByDoctor(doctorId);
            // returns office for doctor, takes in Doctor ID - this is where the JDBC will cover
        } catch(DaoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return office;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path= "/provider/appointments")
    public List<Appointment> getAllAppointments(Principal principal) {

        List<Appointment> appointmentList = new ArrayList<>();

        Appointment appointment = null;
        int doctorId = userDao.getUserByUsername(principal.getName()).getId();


        try{
            appointmentList = doctorDao.getAppointmentsByDoctor(doctorId);

        } catch(DaoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return appointmentList;

    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path= "/provider/office")
    public int createDoctorOffice(@Valid @RequestBody Office office, Principal principal){
        int newOffice = 0; // it is always 1 or more in SQL, 0 means something went wrong

        int doctorId = userDao.getUserByUsername(principal.getName()).getId();

        try{
            newOffice = doctorDao.createOffice(office, doctorId);
        }catch(DaoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return newOffice;
    }



    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/provider/office", method = RequestMethod.PUT)
    public Office updateOffice(@RequestBody Office office, Principal principal) {
        Office updatedOffice = null;

        int doctorId = userDao.getUserByUsername(principal.getName()).getId(); // needed to validate that you are the Dr of this office

        try {
            updatedOffice = doctorDao.updateOfficeById(office);

            // updateOffice method needs to be created in the JDBC
            // return Office object, takes in Office AND Doctor ID
        } catch (DaoException error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Office ID not found.");
        }
        return updatedOffice;
    }
    }







