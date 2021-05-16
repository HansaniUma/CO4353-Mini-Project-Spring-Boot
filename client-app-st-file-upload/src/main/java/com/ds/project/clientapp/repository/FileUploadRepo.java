package com.ds.project.clientapp.repository;

import com.ds.project.clientapp.entity.StFileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepo extends JpaRepository<StFileUpload,Integer> {

}
