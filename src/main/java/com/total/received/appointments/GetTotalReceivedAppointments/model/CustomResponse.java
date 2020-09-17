package com.total.received.appointments.GetTotalReceivedAppointments.model;

import java.math.BigInteger;

public class CustomResponse {

    private BigInteger totalRecResponse;

    public CustomResponse() {
    }

    public BigInteger getTotalRecResponse() {
        return totalRecResponse;
    }

    public void setTotalRecResponse(BigInteger totalRecResponse) {
        this.totalRecResponse = totalRecResponse;
    }
}
