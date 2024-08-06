package com.techelevator.model;

public class Prescription {
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private TimePeriod timePeriod;

    public Prescription (){
        this.doctor = new Doctor();
        this.patient = new Patient();
        this.medication= new Medication();
        this.timePeriod= new TimePeriod();
    }

    public Prescription(Doctor doctor, Patient patient, Medication medication, TimePeriod timePeriod) {
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.timePeriod = timePeriod;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }
}
