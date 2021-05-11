package com.ds.project.clientapp.service;

import com.ds.project.clientapp.entity.StFileUpload;
import com.ds.project.clientapp.repository.StoragePropertiesRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class stFileUploadService {

    public stFileUploadService() {  }

    private StoragePropertiesRepo storagePropertiesRepo;

    public StFileUpload savefile(StFileUpload stFileUpload){
        return StoragePropertiesRepo.save(stFileUpload);
    }


    public Optional<StFileUpload> getFile(Integer fileId) {
        return StoragePropertiesRepo.findById(fileId);
    }

    public List<StFileUpload> getFiles(){
        return StoragePropertiesRepo.findAll();
    }

    public static StFileUpload saveMultipleFile(MultipartFile file) {
        String docname = file.getOriginalFilename();
        try {
            StFileUpload fileUpload = new StFileUpload();
            return StoragePropertiesRepo.save(fileUpload);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}



