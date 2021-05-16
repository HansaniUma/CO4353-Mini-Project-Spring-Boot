package com.ds.project.clientapp.service;

import com.ds.project.clientapp.entity.StudentFile;
import com.ds.project.clientapp.repository.FileUploadRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentFileUploadingService {

    @Autowired
    private FileUploadRepositoty repository;

    public StudentFile saveFile(StudentFile file){
        return repository.save(file);
    }

    public List<StudentFile> saveFiles(List<StudentFile> products) {
        return repository.saveAll(products);
    }

    public List<StudentFile> getFiles() {
        return repository.findAll();
    }

    public StudentFile getFileById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteFile(int id) {
        repository.deleteById(id);
        return "File removed !! " + id;
    }

    public StudentFile updateFile(StudentFile file) {
        StudentFile existingFile = repository.findById(file.getFileId()).orElse(null);
        existingFile.setFileId(file.getFileId());
        existingFile.setClassId(file.getClassId());
        existingFile.setStudentID(file.getStudentID());
        existingFile.setLessonName(file.getLessonName());
        existingFile.setFilePath(file.getFilePath());
        return repository.save(existingFile);
    }

}
