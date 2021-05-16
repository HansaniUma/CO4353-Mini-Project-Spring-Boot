package com.ds.project.clientapp.service;

import com.ds.project.clientapp.entity.StFileUpload;
import com.ds.project.clientapp.repository.FileUploadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class stFileUploadService {

    public stFileUploadService() {  }

    @Autowired
    private FileUploadRepo repo;

    public StFileUpload saveFile(StFileUpload file){
        return repo.save(file);
    }

    public List<StFileUpload> saveFiles(List<StFileUpload> products) {
        return repo.saveAll(products);
    }

    public List<StFileUpload> getFiles() {
        return repo.findAll();
    }

    public StFileUpload getFileById(int id) {
        return repo.findById(id).orElse(null);
    }


    public String deleteFile(int id) {
        repo.deleteById(id);
        return "File removed !! " + id;
    }

    public StFileUpload updateFile(StFileUpload file) {
        StFileUpload existingFile = repo.findById(file.getFile_id()).orElse(null);
        existingFile.setClass_id(file.getClass_id());
        existingFile.setSt_id(file.getSt_id());
        existingFile.setSubmitted_date(file.getSubmitted_date());
        existingFile.setFileType(file.getFileType());
        existingFile.setFileType(file.getFileType());
        existingFile.setPath(file.getPath());
        return repo.save(existingFile);
    }


}



