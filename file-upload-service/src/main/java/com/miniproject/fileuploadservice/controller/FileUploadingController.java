package com.miniproject.fileuploadservice.controller;

import com.miniproject.fileuploadservice.entity.TeacherFile;
import com.miniproject.fileuploadservice.service.TeacherFileUploadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/file")
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
