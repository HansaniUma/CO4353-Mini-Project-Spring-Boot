package com.miniproject.paymentservice.service;

import com.miniproject.paymentservice.entity.Payment;
import com.miniproject.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getPayments(){
       return paymentRepository.findAll();
    }

}
