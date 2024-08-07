package com.techelevator.model;

import java.util.Date;

public class Patient {

    private int patient_Id;
    private String firstName;
    private String lastName;
    private char middleInitials;
    private String gender;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;
    private String patientAddress;
    private String city;
    private String stateAbbreviation;
    private String zipCode;

    public Patient(){

    }

    public Patient(int patient_Id, String firstName, String lastName, char middleInitials, String gender, String phoneNumber, String email,
                   Date dateOfBirth, String patientAddress, String city, String stateAbbreviation, String zipCode) {
        this.patient_Id = patient_Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitials = middleInitials;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.patientAddress = patientAddress;
        this.city = city;
        this.stateAbbreviation = stateAbbreviation;
        this.zipCode = zipCode;
    }

    public int getPatient_Id() {
        return patient_Id;
    }

    public void setPatient_Id(int patient_Id) {
        this.patient_Id = patient_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getMiddleInitials() {
        return middleInitials;
    }

    public void setMiddleInitials(char middleInitials) {
        this.middleInitials = middleInitials;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
