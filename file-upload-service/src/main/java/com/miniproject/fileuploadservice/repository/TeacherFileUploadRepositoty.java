package com.miniproject.fileuploadservice.repository;


import com.miniproject.fileuploadservice.entity.TeacherFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherFileUploadRepositoty extends JpaRepository<TeacherFile,Integer> {
}
