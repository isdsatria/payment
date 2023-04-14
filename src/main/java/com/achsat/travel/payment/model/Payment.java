package com.achsat.travel.payment.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Payment {

    private Long transactionId;
    private Double transactionAmt;
    private String paymentMethod;

}
