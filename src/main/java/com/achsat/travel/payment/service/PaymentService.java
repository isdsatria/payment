package com.achsat.travel.payment.service;

import com.achsat.travel.payment.model.Payment;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class.getPackageName());
    private KafkaTemplate<String, String> template;
    public void reply(String a){
        LOGGER.info(a);
    }
}

