package com.ds.project.clientapp.service;

import com.ds.project.clientapp.entity.StFileUpload;
import com.ds.project.clientapp.repository.StoragePropertiesRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class stFileUploadService {
    private final Path fileStorageLocation;

//    StoragePropertiesRepo storagePropertiesRepo;

    public stFileUploadService(StFileUpload stFileUpload) {
        this.fileStorageLocation = Paths.get(stFileUpload.getPath());


//        try {
//
//            Files.createDirectories(this.fileStorageLocation);
//
//        } catch (Exception ex) {
//
//            throw new DocumentStorageException("Could not create the directory where the uploaded files will be stored.", ex);
//
//        }
    }


    public static String uploadFile(MultipartFile file) {
        return "";
    }

}



