package com.techelevator.model;

public class DoctorServices {

    private Doctor doctor;
    private Services services;

    public DoctorServices() {
        this.doctor= new Doctor();
        this.services=new Services();

    }

    public DoctorServices(Doctor doctor, Services services) {
        this.doctor = doctor;
        this.services = services;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
