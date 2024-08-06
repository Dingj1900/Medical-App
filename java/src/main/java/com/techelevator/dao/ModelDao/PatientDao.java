package com.techelevator.dao.ModelDao;

import com.techelevator.model.Patient;

import java.util.List;

public interface PatientDao {


    //CRUD = CREATE  RETRIEVE UPDATE & DELETE//

    Patient getPatientById (int patientId); //retrieve
   // void addPatient(Patient patient); // add
    Patient createPatient(Patient patient);  // create
    boolean updatePatient(Patient patient);  //update
    boolean deletePatient(int patientId);  //delete

    List<Patient> getAllPatients();//Retrieves all Patient records from the database.
}


