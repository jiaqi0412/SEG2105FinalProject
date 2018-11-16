package com.example.lijia.finalproject;

public class ServiceProviderProfile {

    
    String serviceProviderAddress;
    String serviceProviderPhone;
    String serviceProviderGeneralDescription;
    String serviceProviderCompanyName;

    public ServiceProviderProfile(){

    }

    public ServiceProviderProfile(String serviceProviderAddress,
    String serviceProviderPhone, String serviceProviderGeneralDescription, String serviceProviderCompanyName){
        
        this.serviceProviderAddress = serviceProviderAddress;
        this.serviceProviderPhone = serviceProviderPhone;
        this.serviceProviderGeneralDescription = serviceProviderGeneralDescription;
        this.serviceProviderCompanyName = serviceProviderCompanyName;
    }


    public String getServiceProviderAddress(){
        return serviceProviderAddress;
    }
    public String getServiceProviderPhone(){
        return serviceProviderPhone;
    }
    public String getServiceProviderGeneralDescription(){
        return serviceProviderGeneralDescription;
    }
    public String getServiceProviderCompanyName(){
        return serviceProviderCompanyName;
    }

}
