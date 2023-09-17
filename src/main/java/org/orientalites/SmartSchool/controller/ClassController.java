package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.ClassRepository;
import org.orientalites.SmartSchool.data.models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {

    private final ClassRepository repository;

    public ClassController(@Autowired ClassRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getClasses")
    public Iterable<Class> getClasses() {
        return repository.findAll();
    }

    @PostMapping("/addClass")
    public Class addClass(@RequestBody Class newClass) {
        Logger.getGlobal().log(Level.WARNING, newClass.toString());
        return repository.save(newClass);
    }

    @GetMapping("/getClassByID")
    public Class getClassByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateClass")
    public Class updateClass(@RequestBody Class newClass) {
        return repository.save(newClass);
    }

    @PostMapping("/deleteClass")
    public void deleteClass(@RequestBody Class newClass) {
        repository.delete(newClass);
    }
}
