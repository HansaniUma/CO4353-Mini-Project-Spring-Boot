package com.bhanuka.classstructure.repository;

import com.bhanuka.classstructure.entity.Clz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Clz, Integer> {

    Clz findByModule(String module);
}
