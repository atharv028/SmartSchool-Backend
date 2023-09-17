package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.ParentRepository;
import org.orientalites.SmartSchool.data.models.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ParentController {
    private final ParentRepository repository;

    public ParentController(@Autowired ParentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getParents")
    public Iterable<Parent> getParents() {
        return repository.findAll();
    }

    @PostMapping("/addParent")
    public Parent addParent(@RequestBody Parent newParent) {
        Logger.getGlobal().log(Level.WARNING, newParent.toString());
        return repository.save(newParent);
    }

    @GetMapping("/getParentByID")
    public Parent getParentByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateParent")
    public Parent updateParent(@RequestBody Parent newParent) {
        return repository.save(newParent);
    }

    @PostMapping("/deleteParent")
    public void deleteParent(@RequestBody Parent newParent) {
        repository.delete(newParent);
    }
}
