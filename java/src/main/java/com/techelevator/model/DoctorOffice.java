package com.techelevator.model;

public class DoctorOffice {
    private Doctor doctor;
    private Office office;

    public DoctorOffice() {
        this.doctor = new Doctor();
        this.office= new Office();
    }

    public DoctorOffice(Doctor doctor, Office office) {
        this.doctor = doctor;
        this.office = office;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}

