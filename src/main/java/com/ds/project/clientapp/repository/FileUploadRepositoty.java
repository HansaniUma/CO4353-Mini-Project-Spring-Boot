package com.ds.project.clientapp.repository;

import com.ds.project.clientapp.entity.StudentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepositoty extends JpaRepository<StudentFile,Integer> {
}
