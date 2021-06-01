package com.ds.project.clientapp.repository;

import com.ds.project.clientapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoty extends JpaRepository<Payment,Integer> {
}
