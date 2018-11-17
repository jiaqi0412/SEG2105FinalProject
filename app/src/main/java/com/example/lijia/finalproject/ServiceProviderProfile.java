package com.example.lijia.finalproject;

public class ServiceProviderProfile {

    
    String serviceProviderAddress;
    String serviceProviderPhone;
    String serviceProviderGeneralDescription;
    String serviceProviderCompanyName;
    String serviceProviderId;

    public ServiceProviderProfile(){

    }

    public ServiceProviderProfile(String serviceProviderId,String serviceProviderAddress,
    String serviceProviderPhone, String serviceProviderGeneralDescription,
                                  String serviceProviderCompanyName){
        
        this.serviceProviderAddress = serviceProviderAddress;
        this.serviceProviderPhone = serviceProviderPhone;
        this.serviceProviderGeneralDescription = serviceProviderGeneralDescription;
        this.serviceProviderCompanyName = serviceProviderCompanyName;
        this.serviceProviderId = serviceProviderId;
    }


    public String getServiceProviderAddress(){
        return serviceProviderAddress;
    }
    public String getServiceProviderId(){
        return serviceProviderId;
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
