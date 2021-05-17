package com.miniproject.paymentservice;

import com.miniproject.paymentservice.entity.Payment;
import com.miniproject.paymentservice.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PaymentConfig {

    @Bean
    CommandLineRunner commandLineRunner(PaymentRepository repository){
        return args -> {
            Payment payment1 = new Payment(
                    1L,
                    "Mary",
                    5000L,
                    LocalDate.of(2021, Month.MAY, 17)
            );

            Payment payment2 = new Payment(
                    "Alex",
                    2000L,
                    LocalDate.of(2021, Month.MAY, 16)
            );

            repository.saveAll(
                    List.of(payment1, payment2)
            );
        };
    }
}
