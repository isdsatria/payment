package com.achsat.travel.payment;

import com.achsat.travel.payment.model.Payment;
import com.achsat.travel.payment.service.PaymentService;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@SpringBootApplication
public class PaymentApplication {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentApplication.class.getPackageName());
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

	@Autowired
	PaymentService paymentService;
	@KafkaListener(id="transactions",topics="transaction-payment",groupId="payment")
	public void onEvent(String a){
		LOG.info("Received:{}" ,a );
		paymentService.reply(a);
	}

	@Bean
	public NewTopic PaymentStatus(){
		return TopicBuilder.name("payment-status")
				.partitions(3)
				.compact()
				.build();
	}

	@Bean
	public NewTopic TransactionPayment(){
		return TopicBuilder.name("transaction-payment")
				.partitions(3)
				.compact()
				.build();
	}

}
