package com.techelevator.model;

import java.time.LocalTime;

public class Appointment {

    private int appointmentId;

    private int serviceId;
    private int officeId;
    private int patientId;
    private  int doctorId;
    private LocalTime apptFrom;
    private LocalTime apptTo;
    private boolean openMonday;
    private boolean openTuesday;
    private boolean openWednesday;
    private boolean openThursday;
    private boolean openFriday;
    private boolean openSaturday;
    private boolean openSunday;
    private boolean notified;
    private boolean approved;

    public Appointment () {}

    public Appointment(int appointmentId, int officeId, int patientId, int doctorId, boolean isNotified, boolean isApproved) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.officeId = officeId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.apptFrom = apptFrom;
        this.apptTo = apptTo;
        this.openMonday = openMonday;
        this.openTuesday = openTuesday;
        this.openWednesday = openWednesday;
        this.openThursday = openThursday;
        this.openFriday = openFriday;
        this.openSaturday = openSaturday;
        this.openSunday = openSunday;
        this.notified = notified;
        this.approved = approved;
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

    public boolean isOpenMonday() {
        return openMonday;
    }

    public void setOpenMonday(boolean openMonday) {
        this.openMonday = openMonday;
    }

    public boolean isOpenTuesday() {
        return openTuesday;
    }

    public void setOpenTuesday(boolean openTuesday) {
        this.openTuesday = openTuesday;
    }

    public boolean isOpenWednesday() {
        return openWednesday;
    }

    public void setOpenWednesday(boolean openWednesday) {
        this.openWednesday = openWednesday;
    }

    public boolean isOpenThursday() {
        return openThursday;
    }

    public void setOpenThursday(boolean openThursday) {
        this.openThursday = openThursday;
    }

    public boolean isOpenFriday() {
        return openFriday;
    }

    public void setOpenFriday(boolean openFriday) {
        this.openFriday = openFriday;
    }

    public boolean isOpenSaturday() {
        return openSaturday;
    }

    public void setOpenSaturday(boolean openSaturday) {
        this.openSaturday = openSaturday;
    }

    public boolean isOpenSunday() {
        return openSunday;
    }

    public void setOpenSunday(boolean openSunday) {
        this.openSunday = openSunday;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}




