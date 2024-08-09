package com.techelevator.model;

import java.time.LocalTime;

public class Appointment {

    private int appointmentId;
    private int officeId;
    private int patientId;
    private  int doctorId;
    private LocalTime apptFrom;
    private LocalTime apptTo;
    private boolean isMonday;
    private boolean isTuesday;
    private boolean isWednesday;
    private boolean isThursday;
    private boolean isFriday;
    private boolean isSaturday;
    private boolean isSunday;
    private boolean isNotified;
    private boolean isApproved;

    public Appointment () {}

    public Appointment(int appointmentId, int officeId, int patientId, int doctorId, boolean isNotified, boolean isApproved) {
        this.appointmentId = appointmentId;
        this.officeId = officeId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.apptFrom = apptFrom;
        this.apptTo = apptTo;
        this.isMonday = isMonday;
        this.isTuesday = isTuesday;
        this.isWednesday = isWednesday;
        this.isThursday = isThursday;
        this.isFriday = isFriday;
        this.isSaturday = isSaturday;
        this.isSunday = isSunday;
        this.isNotified = isNotified;
        this.isApproved = isApproved;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

//    public boolean createAppointment(Appointment appointment){
//
//        return false;
//    }

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

    public LocalTime getApptFrom() {
        return apptFrom;
    }

    public void setApptFrom(LocalTime apptFrom) {
        this.apptFrom = apptFrom;
    }

    public LocalTime getApptTo() {
        return apptTo;
    }

    public void setApptTo(LocalTime apptTo) {
        this.apptTo = apptTo;
    }

    public boolean isMonday() {
        return isMonday;
    }

    public void setMonday(boolean monday) {
        isMonday = monday;
    }

    public boolean isTuesday() {
        return isTuesday;
    }

    public void setTuesday(boolean tuesday) {
        isTuesday = tuesday;
    }

    public boolean isWednesday() {
        return isWednesday;
    }

    public void setWednesday(boolean wednesday) {
        isWednesday = wednesday;
    }

    public boolean isThursday() {
        return isThursday;
    }

    public void setThursday(boolean thursday) {
        isThursday = thursday;
    }

    public boolean isFriday() {
        return isFriday;
    }

    public void setFriday(boolean friday) {
        isFriday = friday;
    }

    public boolean isSaturday() {
        return isSaturday;
    }

    public void setSaturday(boolean saturday) {
        isSaturday = saturday;
    }

    public boolean isSunday() {
        return isSunday;
    }

    public void setSunday(boolean sunday) {
        isSunday = sunday;
    }
}




