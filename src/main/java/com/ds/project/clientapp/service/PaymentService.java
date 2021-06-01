package com.ds.project.clientapp.service;

import com.ds.project.clientapp.entity.Payment;
import com.ds.project.clientapp.repository.PaymentRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepositoty repository;

    public Payment savePayment(Payment file){
        return repository.save(file);
    }

    public List<Payment> savePayments(List<Payment> products) {
        return repository.saveAll(products);
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public Payment getPaymentByStuId(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteFile(int id) {
        repository.deleteById(id);
        return "File removed !! " + id;
    }

    public Payment updateFile(Payment file) {
        Payment existingFile = repository.findById(file.getPaymentId()).orElse(null);
        existingFile.setClassId(file.getClassId());
        existingFile.setUserID(file.getUserID());
        existingFile.setAmount(file.getAmount());
        return repository.save(existingFile);
    }

}
