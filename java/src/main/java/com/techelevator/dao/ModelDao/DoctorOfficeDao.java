package com.techelevator.dao.ModelDao;
import com.techelevator.model.DoctorOffice;

import java.util.List;

public interface DoctorOfficeDao {

    DoctorOffice createDoctorOffice(DoctorOffice doctorOffice);
    DoctorOffice getDoctorOfficeByDoctorId(int doctorId);
    DoctorOffice getDoctorOfficeByOfficeId(int officeId);
    List<DoctorOffice> getAllDoctorOffices();
    boolean updateDoctorOffice(DoctorOffice doctorOffice);
    boolean deleteDoctorOffice(int doctorId, int officeId);
}

