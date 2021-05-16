package com.miniproject.classservice.service;


import com.miniproject.classservice.entity.ClassDetail;
import com.miniproject.classservice.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
//    This service should call to the class repository
    @Autowired
    private ClassRepository repository;

//    POST
    public ClassDetail saveClz(ClassDetail clz){
        return repository.save(clz);
    }

    public List<ClassDetail> saveClzs(List<ClassDetail> clzs){
        return repository.saveAll(clzs);
    }

//    GET
    public List<ClassDetail> getClzs(){
        return repository.findAll();
    }

    public ClassDetail getClzById(int id){
        return repository.findById(id).orElse(null);
    }

    public ClassDetail getClzByModule(String module){
        return repository.findByModule(module);
    }
//DELETE
    public String deleteClz(int id){
        repository.deleteById(id);
        return "Class Removed from the list" + id;
    }

//    PUT
    public ClassDetail updateClz(ClassDetail clz){
        ClassDetail existingClz = repository.findById(clz.getClass_id()).orElse(null); //FETCH THE EXISTING CLASS BASED ON ID
        existingClz.setModule(clz.getModule());
        existingClz.setDay(clz.getDay());
        existingClz.setTeacher_id(clz.getTeacher_id());
        return repository.save(existingClz);
    }


}
