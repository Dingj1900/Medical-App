package com.techelevator.model;

public class DoctorOffice {
    private User doctor;
    private Office office;

    public DoctorOffice() {

    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}

