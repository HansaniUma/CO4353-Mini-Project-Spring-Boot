package com.ds.project.clientapp.controller;

import com.ds.project.clientapp.beans.StFileUploadBeans;
import com.ds.project.clientapp.service.stFileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/st-file-controll")
@RestController
public class stFileController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file: files) {
            stFileUploadService.saveMultipleFile(file);

        }
        return "redirect:/";
    }

    @GetMapping("/st-file-upload/from/{from}/to/{to}/quantity/{quantity}")
    public StFileUploadBeans fileUploadBeans(
            @PathVariable Integer file_id,
            @PathVariable Integer st_id,
            @PathVariable Integer class_id,
            @PathVariable Date submitted_date,
            @PathVariable String path,
            @PathVariable String fileType,
            @PathVariable byte[] data

             ){


        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("file_id", file_id);
//        uriVariables.put("st_id", st_id);
//        uriVariables.put("class_id", class_id);
//        uriVariables.put("submitted_date", submitted_date);
        uriVariables.put("fileType", fileType);
//        uriVariables.put("data", data);



        ResponseEntity<StFileUploadBeans> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/st-file-upload", StFileUploadBeans.class,
                uriVariables);

        StFileUploadBeans response = responseEntity.getBody();

        return new StFileUploadBeans(
                response.getFile_id(),
                response.getSt_id(),
                response.getClass_id(),
                response.getSubmitted_date(),
                response.getPath(),
                response.getPort());
    }


//    private StFileUploadProxy ;




}
