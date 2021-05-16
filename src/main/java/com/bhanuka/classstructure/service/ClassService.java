package com.bhanuka.classstructure.service;

import com.bhanuka.classstructure.entity.Clz;
import com.bhanuka.classstructure.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
//    This service should call to the class repository
    @Autowired
    private ClassRepository repository;

//    POST
    public Clz saveClz(Clz clz){
        return repository.save(clz);
    }

    public List<Clz> saveClzs(List<Clz> clzs){
        return repository.saveAll(clzs);
    }

//    GET
    public List<Clz> getClzs(){
        return repository.findAll();
    }

    public Clz getClzById(int id){
        return repository.findById(id).orElse(null);
    }

    public Clz getClzByModule(String module){
        return repository.findByModule(module);
    }
//DELETE
    public String deleteClz(int id){
        repository.deleteById(id);
        return "Class Removed from the list" + id;
    }

//    PUT
    public Clz updateClz( Clz clz){
        Clz existingClz = repository.findById(clz.getClass_id()).orElse(null); //FETCH THE EXISTING CLASS BASED ON ID
        existingClz.setModule(clz.getModule());
        existingClz.setDay(clz.getDay());
        existingClz.setTeacher_id(clz.getTeacher_id());
        return repository.save(existingClz);
    }


}
