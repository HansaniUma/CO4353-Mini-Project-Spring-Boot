package com.miniproject.classservice.controller;

import com.miniproject.classservice.entity.ClassDetail;
import com.miniproject.classservice.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService service;

    @PostMapping("/addClass")
    public ClassDetail addClz(@RequestBody ClassDetail classDetail){
        return service.saveClz(classDetail);
    }

    @PostMapping("/addClasses")
    public List<ClassDetail> addClzs(@RequestBody List<ClassDetail> classDetails){
        return service.saveClzs(classDetails);
    }

    @GetMapping("/classes")
    public List<ClassDetail> findAllClzs(){
        return service.getClzs();
    }

    @GetMapping("/classById/{id}")
    public ClassDetail findClzById(@PathVariable int id){
        return service.getClzById(id);
    }

    @GetMapping("/classByModule/{module}")
    public ClassDetail findClzByModule(@PathVariable String module){
        return service.getClzByModule(module);
    }

    @PutMapping("/update")
    public ClassDetail updateClz(@RequestBody ClassDetail classDetail){
        return service.updateClz(classDetail);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClz(@PathVariable int id){
        return service.deleteClz(id);
    }


}
