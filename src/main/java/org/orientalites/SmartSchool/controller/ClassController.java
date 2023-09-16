package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {

    private final ClassRepository repository;

    public ClassController(@Autowired ClassRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/classes")
    public Iterable<org.orientalites.SmartSchool.data.models.Class> getClasses() {
        return repository.findAll();
    }

    @PostMapping("/classes")
    public org.orientalites.SmartSchool.data.models.Class addClass(
            @RequestBody org.orientalites.SmartSchool.data.models.Class newClass) {
        Logger.getGlobal().log(Level.WARNING, newClass.toString());
        return repository.save(newClass);
    }
}
