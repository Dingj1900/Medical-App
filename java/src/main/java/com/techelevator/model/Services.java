package com.techelevator.model;

public class Services {
    private int serviceId;
    private String serviceName;
    private String serviceDetails;

    public Services(int serviceId, String serviceName, String serviceDetails) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceDetails = serviceDetails;
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
}
