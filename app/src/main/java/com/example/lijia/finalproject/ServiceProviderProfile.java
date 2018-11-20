package com.example.lijia.finalproject;

import android.content.Intent;
import android.view.View;

public class ServiceProviderProfile {

    
    String serviceProviderAddress;
    String serviceProviderPhone;
    String serviceProviderGeneralDescription;
    String serviceProviderCompanyName;
    String strYesOrNo;
    String availability1;
    String availability2;
    String availability3;
    String availability4;
    //String serviceProviderId;

    public ServiceProviderProfile(){

    }

    public ServiceProviderProfile(String serviceProviderAddress,
                                  String serviceProviderPhone, String serviceProviderGeneralDescription,
                                  String serviceProviderCompanyName,String strYesOrNo, String availability1, String availability2,String availability3
            ,String availability4 ){
        
        this.serviceProviderAddress = serviceProviderAddress;
        this.serviceProviderPhone = serviceProviderPhone;
        this.serviceProviderGeneralDescription = serviceProviderGeneralDescription;
        this.serviceProviderCompanyName = serviceProviderCompanyName;
        this.strYesOrNo = strYesOrNo;
        this.availability1 =availability1;
        this.availability2 =availability2;
        this.availability3 =availability3;
        this.availability4 =availability4;

        //this.serviceProviderId = serviceProviderId;
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
    public String getStrYesOrNo(){
        return strYesOrNo;
    }
    public String getAvailability1(){
        return availability1;
    }
    public String getAvailability2(){
        return availability2;
    }
    public String getAvailability3(){
        return availability3;
    }
    public String getAvailability4(){
        return availability4;
    }


}
