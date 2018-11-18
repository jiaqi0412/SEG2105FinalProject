package com.example.lijia.finalproject;

import android.content.Intent;
import android.view.View;

public class ServiceProviderProfile {

    
    String serviceProviderAddress;
    String serviceProviderPhone;
    String serviceProviderGeneralDescription;
    String serviceProviderCompanyName;
    //String serviceProviderId;

    public ServiceProviderProfile(){

    }

    public ServiceProviderProfile(String serviceProviderAddress,
    String serviceProviderPhone, String serviceProviderGeneralDescription,
                                  String serviceProviderCompanyName){
        
        this.serviceProviderAddress = serviceProviderAddress;
        this.serviceProviderPhone = serviceProviderPhone;
        this.serviceProviderGeneralDescription = serviceProviderGeneralDescription;
        this.serviceProviderCompanyName = serviceProviderCompanyName;
        //this.serviceProviderId = serviceProviderId;
    }


    public String getServiceProviderAddress(){
        return serviceProviderAddress;
    }
    /*public String getServiceProviderId(){
        return serviceProviderId;
    }*/
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
