package com.techelevator.model;

public class Services {
    private int serviceId;
    private String serviceName;
    private String serviceDetails;

    private double hourlyRate;

    private int doctorId;

    public Services() {
    }

    public Services(int serviceId, String serviceName, String serviceDetails, double hourlyRate, int doctorId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDetails = serviceDetails;
        this.hourlyRate = hourlyRate;
        this.doctorId = doctorId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
