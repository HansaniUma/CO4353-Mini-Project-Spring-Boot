package com.ds.project.clientapp.repository;

import com.ds.project.clientapp.entity.TeacherFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepositoty extends JpaRepository<TeacherFile,Integer> {
}
