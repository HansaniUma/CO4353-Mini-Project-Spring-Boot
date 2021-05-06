package com.ds.project.clientapp.controller;


import com.ds.project.clientapp.beans.StFileUploadBeans;
import com.ds.project.clientapp.beans.StFileUploadValue;
//import com.ds.project.clientapp.service.stFileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.ws.rs.core.Response;
import java.util.List;


@RestController
@RequestMapping("/st-file-upload")
public class StFileUploadController {

    @Autowired
    StFileUploadBeans stFileUploadBeans;

    @RequestMapping("accessStUploadFile")
    public StFileUploadValue accessStUploadFile(){

        refreshActuator();

        return new StFileUploadValue(
                stFileUploadBeans.getFile_id(),
                stFileUploadBeans.getSt_id(),
                stFileUploadBeans.getClass_id(),
                stFileUploadBeans.getSubmitted_date(),
                stFileUploadBeans.getPath()
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

    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
//        String fileName = stFileUploadService.uploadFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();

//        return new Response(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
        return null;
    }

    private final RestTemplate restTemplate;


    public StFileUploadController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

//    @GetMapping("/stupload")
//    public ResponseEntity<List<>> listClasses() {
//        return restTemplate
//                .exchange("http://school-service/classes", HttpMethod.GET, null,
//                        new ParameterizedTypeReference<List<>>() {});
//    }
}
