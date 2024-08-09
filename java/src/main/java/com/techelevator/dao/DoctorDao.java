package com.techelevator.dao;

import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;

import java.util.List;

public interface DoctorDao {


    Office getOfficeByDoctor(int doctorId);



}
