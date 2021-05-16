package com.bhanuka.classstructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clz")
public class Clz {

    @Id
    @GeneratedValue
    private int class_id;
    private String module;
    private LocalDateTime day;
    private int teacher_id;
}
