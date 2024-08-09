package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   private int id;
   private String username;
   @JsonIgnore
   private String password;
   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();

   // CHANGES FROM OUR DATABASE AFTER MODIFYING USERS
   private  String firstName;
   private  String lastName;
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
   private boolean isMonday;
   private boolean isTuesday;
   private boolean isWednesday;
   private boolean isThursday;
   private boolean isFriday;
   private boolean isSaturday;
   private boolean isSunday;

   public User() { }

   //CREATING GETTERS & SETTERS FOR THE ADDITIONAL USER INFORMATION


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

   public LocalDate getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
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

   public User(int id, String username, String password, String authorities) {
      this.id = id;
      this.username = username;
      this.password = password;
      if (authorities != null) this.setAuthorities(authorities);
      this.activated = true;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
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

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   public void setAuthorities(String authorities) {
      String[] roles = authorities.split(",");
      for (String role : roles) {
         String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
         this.authorities.add(new Authority(authority));
      }
   }



   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(authorities, user.authorities);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, activated, authorities);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              '}';
   }

}
