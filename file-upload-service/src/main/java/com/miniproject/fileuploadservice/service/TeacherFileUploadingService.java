package com.miniproject.fileuploadservice.service;


import com.miniproject.fileuploadservice.entity.TeacherFile;
import com.miniproject.fileuploadservice.repository.TeacherFileUploadRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherFileUploadingService {

    @Autowired
    private TeacherFileUploadRepositoty repository;

    public TeacherFile saveFile(TeacherFile file){
        return repository.save(file);
    }

    public List<TeacherFile> saveFiles(List<TeacherFile> products) {
        return repository.saveAll(products);
    }

    public List<TeacherFile> getFiles() {
        return repository.findAll();
    }

    public TeacherFile getFileById(int id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteFile(int id) {
        repository.deleteById(id);
        return "File removed !! " + id;
    }

    public TeacherFile updateFile(TeacherFile file) {
        TeacherFile existingFile = repository.findById(file.getFileId()).orElse(null);
        existingFile.setClassId(file.getClassId());
        existingFile.setTeacherID(file.getTeacherID());
        existingFile.setTeacherName(file.getTeacherName());
        existingFile.setFilePath(file.getFilePath());
        return repository.save(existingFile);
    }

}
