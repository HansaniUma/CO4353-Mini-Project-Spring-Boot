package com.miniproject.fileuploadservice.repository;

import com.miniproject.fileuploadservice.entity.StudentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentFileUploadRepository  extends JpaRepository<StudentFile,Integer> {
}
