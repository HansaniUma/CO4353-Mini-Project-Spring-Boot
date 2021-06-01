package com.ds.project.clientapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_TBL")
public class Payment {

    @Id
    @GeneratedValue
    private int paymentId;
    private int classId;
    private int userID;
    private double amount;

}
