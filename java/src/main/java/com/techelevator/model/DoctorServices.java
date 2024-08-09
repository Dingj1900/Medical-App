package com.techelevator.model;

public class DoctorServices {

    private User doctor;
    private Services services;

    public DoctorServices() {

    }



    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
