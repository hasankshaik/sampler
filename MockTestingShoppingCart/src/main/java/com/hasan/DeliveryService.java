package com.hasan;


import javax.inject.Inject;

/**
 * Created by home on 07/10/2017.
 */
public class DeliveryService {
    private final static int STANDARD_DELIVERY = 10;

    @Inject
    private int someAddConst;

    protected Availability availability;

    public int calculateDelivery() {
        System.out.println(availability.getName());
        return STANDARD_DELIVERY+someAddConst;
    }
}
