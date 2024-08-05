package com.techelevator.model;

public class Appointment {

    private int appointmentId;
    private int officeId;
    private int patientId;
    private  int doctorId;
    private boolean isNotified;
    private boolean isApproved;


    public Appointment(int appointmentId, int officeId, int patientId, int doctorId, boolean isNotified, boolean isApproved) {
        this.appointmentId = appointmentId;
        this.officeId = officeId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.isNotified = isNotified;
        this.isApproved = isApproved;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public boolean isNotified() {
        return isNotified;
    }

    public void setNotified(boolean notified) {
        isNotified = notified;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}




