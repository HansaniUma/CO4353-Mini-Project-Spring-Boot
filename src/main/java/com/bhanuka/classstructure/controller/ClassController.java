package com.bhanuka.classstructure.controller;

import com.bhanuka.classstructure.entity.Clz;
import com.bhanuka.classstructure.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private ClassService service;

    @PostMapping("/addClass")
    public Clz addClz(@RequestBody Clz clz){
        return service.saveClz(clz);
    }

    @PostMapping("/addClasses")
    public List<Clz> addClzs(@RequestBody List<Clz> clzs){
        return service.saveClzs(clzs);
    }

    @GetMapping("/classes")
    public List<Clz> findAllClzs(){
        return service.getClzs();
    }

    @GetMapping("/classById/{id}")
    public Clz findClzById(@PathVariable int id){
        return service.getClzById(id);
    }

    @GetMapping("/classByModule/{module}")
    public Clz findClzByModule(@PathVariable String module){
        return service.getClzByModule(module);
    }

    @PutMapping("/update")
    public Clz updateClz(@RequestBody Clz clz){
        return service.updateClz(clz);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClz(@PathVariable int id){
        return service.deleteClz(id);
    }


}
