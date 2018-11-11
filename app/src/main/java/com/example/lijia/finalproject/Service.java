package com.example.lijia.finalproject;

public class Service {

    String serviceName;
    String serviceId;
    String serviceHourlyRate;

    public Service(){

    }

    public Service(String serviceId, String serviceName, String serviceHourlyRate){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceHourlyRate = serviceHourlyRate;
    }

    public String getServiceId(){
        return serviceId;
    }
    public String getServiceName(){
        return serviceName;
    }
    public String getServiceHourlyRate(){
        return serviceHourlyRate;
    }
}
