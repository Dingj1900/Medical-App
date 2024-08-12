package com.techelevator.model;

import java.time.LocalTime;

public class AppointmentDto {

        private String doctorName;
        private String serviceDescription;
        private String officeName;
        private String officeAddress;
        private String officePhone;
        private int appointmentId;
        private int serviceId;
        private int officeId;
        private int patientId;
        private  int doctorId;
        private boolean notified;
        private boolean approved;
        private String apptDate;

        public AppointmentDto () {}

//        public AppointmentDto(String doctorName, String serviceDescription, String officeName, String officeAddress, String officePhone, int appointmentId, int serviceId, int officeId, int patientId, int doctorId, LocalTime apptFrom, LocalTime apptTo, boolean openMonday, boolean openTuesday, boolean openWednesday, boolean openThursday, boolean openFriday, boolean openSaturday, boolean openSunday, boolean notified, boolean approved) {
//        this.doctorName = doctorName;
//        this.serviceDescription = serviceDescription;
//        this.officeName = officeName;
//        this.officeAddress = officeAddress;
//        this.officePhone = officePhone;
//        this.appointmentId = appointmentId;
//        this.serviceId = serviceId;
//        this.officeId = officeId;
//        this.patientId = patientId;
//        this.doctorId = doctorId;
//        this.apptFrom = apptFrom;
//        this.apptTo = apptTo;
//        this.openMonday = openMonday;
//        this.openTuesday = openTuesday;
//        this.openWednesday = openWednesday;
//        this.openThursday = openThursday;
//        this.openFriday = openFriday;
//        this.openSaturday = openSaturday;
//        this.openSunday = openSunday;
//        this.notified = notified;
//        this.approved = approved;


    public String getApptDate() {
        return apptDate;
    }

    public void setApptDate(String appt_date) {
        this.apptDate = appt_date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

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

