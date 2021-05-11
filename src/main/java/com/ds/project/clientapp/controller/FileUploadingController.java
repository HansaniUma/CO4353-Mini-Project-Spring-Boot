package com.ds.project.clientapp.controller;

import com.ds.project.clientapp.entity.TeacherFile;
import com.ds.project.clientapp.service.TeacherFileUploadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileUploadingController {

    @Autowired
    private TeacherFileUploadingService service;

    @PostMapping("/addFile")
    public TeacherFile addFile(@RequestBody TeacherFile file) {
        return service.saveFile(file);
    }

    @PostMapping("/addFiles")
    public List<TeacherFile> addFiles(@RequestBody List<TeacherFile> files) {
        return service.saveFiles(files);
    }

    @GetMapping("/files")
    public List<TeacherFile> findAllFiles() {
        return service.getFiles();
    }

    @GetMapping("/fileById/{id}")
    public TeacherFile findFileById(@PathVariable int id) {
        return service.getFileById(id);
    }


    @PutMapping("/update")
    public TeacherFile updateFile(@RequestBody TeacherFile file) {
        return service.updateFile(file);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFile(@PathVariable int id) {
        return service.deleteFile(id);
    }


}
