package com.ds.project.clientapp.controller;


import com.ds.project.clientapp.beans.StFileUploadBeans;
import com.ds.project.clientapp.beans.StFileUploadValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.ds.project.clientapp.service.stFileUploadService;


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
//    @PostMapping("/uploadFiles")
//    public String uploadMultipleFiles(@RequestMappinguestParam MultipartFile[] files) {
//        for (MultipartFile file: files) {
//            stFileUploadService.saveFile(file);
//
//        }
//        return "redirect:/";
//    }
//
//    private stFileUploadService  stFileUploadService;
//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer file_id){
//        Doc doc = (Doc) stFileUploadService.getFile(file_id).get();
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(doc.toString()))
//                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocFlavor()+"\"")
//                .body(new ByteArrayResource(doc.getData()));
////        return null;
//    }


}
