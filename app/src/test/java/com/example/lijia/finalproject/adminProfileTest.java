package com.example.lijia.finalproject;

import static org.junit.Assert.*;
import org.junit.Test;

public class adminProfileTest {

    @Test
    public void checkServiceName1() {
        Service aService = new Service("LQzecEvQaW_o4FTQac", "Wash", "50");
        assertEquals("Check the name of the service", "Wash", aService.getServiceName());
    }

    @Test
    public void checkServiceHourlyRate2() {
        Service aService = new Service("LQzecEvQaW_o4FTQac", "Wash", "50");
        assertEquals("Check the ServiceHourlyRate of the service", "50", aService.getServiceHourlyRate());
    }

    @Test
    public void checkServiceName3() {
        Service aService = new Service("-LQM4-UkI6zNm6ZBdSzs", "cleaning floor", "56");
        assertEquals("Check the name of the service", "cleaning floor", aService.getServiceName());
    }

    @Test
    public void checkServiceName4() {
        Service aService = new Service("LQM41fJIiwsSUjbkQX3", "cleaning door", "180");
        assertEquals("Check the name of the service", "cleaning door", aService.getServiceName());
    }

    @Test
    public void checkServiceName5() {
        Service aService = new Service("-LQpgl-qkAd7a25UBEVN", "cleaning window", "155");
        assertEquals("Check the name of the service", "cleaning window", aService.getServiceName());
    }
}
