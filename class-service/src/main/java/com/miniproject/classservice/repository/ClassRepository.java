package com.miniproject.classservice.repository;


import com.miniproject.classservice.entity.ClassDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassDetail, Integer> {

    ClassDetail findByModule(String module);
}
