package com.ds.project.clientapp.controller;

import com.ds.project.clientapp.entity.Payment;
import com.ds.project.clientapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment file) {
        return service.savePayment(file);
    }

    @PostMapping("/addPayments")
    public List<Payment> addPayments(@RequestBody List<Payment> files) {
        return service.savePayments(files);
    }

    @GetMapping("/allPayments")
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/paymentByUserId/{userID}")
    public Payment getPaymentByStuId(@PathVariable int userID) {
        return service.getPaymentByStuId(userID);
    }


//    @PutMapping("/update")
//    public Payment updateFile(@RequestBody Payment file) {
//        return service.updateFile(file);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteFile(@PathVariable int id) {
        return service.deleteFile(id);
    }


}
