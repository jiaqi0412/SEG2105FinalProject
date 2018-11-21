package com.example.lijia.finalproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class serviceProviderInfoTest {

    @Test
    public void checkServiceProviderInfo1() {
        ServiceProviderProfile aService = new ServiceProviderProfile("sas","","","","","","","","");
        assertEquals("Check the address of the service", "sas", aService.getServiceProviderAddress());
    }

    @Test
    public void checkServiceProviderInfo2() {
        ServiceProviderProfile aService = new ServiceProviderProfile("sas","1","","","","","","","");
        assertEquals("Check the phone of the service", "1", aService.getServiceProviderPhone());
    }
}
