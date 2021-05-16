package com.ds.project.clientapp.controller;

import com.ds.project.clientapp.entity.StudentFile;
import com.ds.project.clientapp.service.StudentFileUploadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileUploadingController {

    @Autowired
    private StudentFileUploadingService service;

    @PostMapping("/addFile")
    public StudentFile addFile(@RequestBody StudentFile file) {
        return service.saveFile(file);
    }

    @PostMapping("/addFiles")
    public List<StudentFile> addFiles(@RequestBody List<StudentFile> files) {
        return service.saveFiles(files);
    }

    @GetMapping("/files")
    public List<StudentFile> findAllFiles() {
        return service.getFiles();
    }

    @GetMapping("/fileById/{id}")
    public StudentFile findFileById(@PathVariable int id) {
        return service.getFileById(id);
    }


    @PutMapping("/update")
    public StudentFile updateFile(@RequestBody StudentFile file) {
        return service.updateFile(file);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFile(@PathVariable int id) {
        return service.deleteFile(id);
    }


}
