package com.ds.project.clientapp.repository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.ds.project.clientapp.entity.StFileUpload;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StoragePropertiesRepo extends JpaRepository {

    static Optional<StFileUpload> findById(Integer fileId){
        return null;
    }

    static List<StFileUpload> findAll() {
        return null;
    }

    static StFileUpload save(StFileUpload fileUpload) {
        return null;
    }
}
