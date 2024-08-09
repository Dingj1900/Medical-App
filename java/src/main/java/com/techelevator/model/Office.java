package com.techelevator.model;

import java.time.LocalTime;

public class Office {
    private int officeId;
    private String officeName;
    private String officeAddress;
    private String phoneNumber;
    private LocalTime hoursFrom;
    private LocalTime hoursTo;
    private String dayFrom;
    private String dayTo;
    private int doctorId; //check with team

    public Office(){

    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalTime getHoursFrom() {
        return hoursFrom;
    }

    public void setHoursFrom(LocalTime hoursFrom) {
        this.hoursFrom = hoursFrom;
    }

    public LocalTime getHoursTo() {
        return hoursTo;
    }

    public void setHoursTo(LocalTime hoursTo) {
        this.hoursTo = hoursTo;
    }

    public String getDayFrom() {
        return dayFrom;
    }

    public void setDayFrom(String dayFrom) {
        this.dayFrom = dayFrom;
    }

    public String getDayTo() {
        return dayTo;
    }

    public void setDayTo(String dayTo) {
        this.dayTo = dayTo;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
