package com.techelevator.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/*
    The acronym DTO is being used for "data transfer object". It means that this type of class is specifically
    created to transfer data between the client and the server. For example, CredentialsDto represents the data a client must
    pass to the server for a login endpoint, and TokenDto represents the object that's returned from the server
    to the client from a login endpoint.
 */
public class RegisterUserDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @NotEmpty(message = "Please select a role for this user.")
    private String role;

    private String firstName;
    private String lastName;
    private String middleInitials;
    private String gender;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private String city;
    private String stateAbbreviation;
    private String zipcode;
    private LocalTime hoursFrom;
    private LocalTime hoursTo;
    private boolean openMonday;
    private boolean openTuesday;
    private boolean openWednesday;
    private boolean openThursday;
    private boolean openFriday;
    private boolean openSaturday;
    private boolean openSunday;
    private String officeName;
    private String officeAddress;
    private String officePhone;

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
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

    public String getMiddleInitials() {
        return middleInitials;
    }

    public void setMiddleInitials(String middleInitials) {
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
