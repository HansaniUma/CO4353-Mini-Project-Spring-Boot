package com.ds.project.clientapp.repository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import com.ds.project.clientapp.entity.StFileUpload;
import org.springframework.stereotype.Repository;


@Repository
public interface StoragePropertiesRepo extends JpaRepository <StFileUpload,String>{

}
