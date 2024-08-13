package com.techelevator.model;

import java.time.LocalTime;

public class Appointment {

    private int appointmentId;

    private int serviceId;
    private int officeId;
    private int patientId;
    private  int doctorId;
    private String apptDate;
    private boolean notified;
    private boolean approved;

    public Appointment () {}

    public Appointment(int appointmentId, int officeId, int patientId, int doctorId, int serviceId, boolean notified, boolean approved, String apptDate) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.officeId = officeId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.notified = notified;
        this.approved = approved;
        this.apptDate = apptDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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

    public boolean getNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getApptDate() {
        return apptDate;
    }

    public void setApptDate(String apptDate) {
        this.apptDate = apptDate;
    }
}




