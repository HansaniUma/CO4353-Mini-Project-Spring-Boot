package com.ds.project.clientapp.controller;


import com.ds.project.clientapp.beans.StFileUploadBeans;
import com.ds.project.clientapp.beans.StFileUploadValue;
import com.ds.project.clientapp.entity.StFileUpload;
import com.ds.project.clientapp.service.stFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
//@RequestMapping("/st-file-upload")
public class StFileUploadController {



    @Autowired
    StFileUploadBeans stFileUploadBeans;

//    @RequestMapping("accessStUploadFile")
    public StFileUploadValue accessStUploadFile(){

        refreshActuator();

        return new StFileUploadValue(
                stFileUploadBeans.getFile_id(),
                stFileUploadBeans.getSt_id(),
                stFileUploadBeans.getClass_id(),
                stFileUploadBeans.getSubmitted_date(),
                stFileUploadBeans.getPath(),
                stFileUploadBeans.getFileType(),
                stFileUploadBeans.getData()
        );



    }


    public void refreshActuator(){
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type","application/json");

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> results = restTemplate.postForEntity(baseUrl,httpEntity,String.class);

    }

//////////////////////////////////////////////
    //Constructer with rest template

    private final RestTemplate restTemplate;

    public StFileUploadController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
//////////////////////////////////////////////////


/////////////// File Upload //////////////////////////////////////////

    @Autowired
    private stFileUploadService service;

    @PostMapping("/addFile")
    public StFileUpload addFile(@RequestBody StFileUpload file) {
        return service.saveFile(file);
    }

    @PostMapping("/addFiles")
    public List<StFileUpload> addFiles(@RequestBody List<StFileUpload> files) {
        return service.saveFiles(files);
    }

    @GetMapping("/files")
    public List<StFileUpload> findAllFiles() {
        return service.getFiles();
    }

    @GetMapping("/fileById/{id}")
    public StFileUpload findFileById(@PathVariable int id) {
        return service.getFileById(id);
    }


    @PutMapping("/update")
    public StFileUpload updateFile(@RequestBody StFileUpload file) {
        return service.updateFile(file);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFile(@PathVariable int id) {
        return service.deleteFile(id);
    }


}
