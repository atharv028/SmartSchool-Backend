package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.CollegeRepository;
import org.orientalites.SmartSchool.data.models.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollegeController {

    private final CollegeRepository repository;

    public CollegeController(@Autowired CollegeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getColleges")
    public Iterable<College> getColleges() {
        return repository.findAll();
    }

    @PostMapping("/addCollege")
    public College addCollege(@RequestBody College newCollege) {
        Logger.getGlobal().log(Level.WARNING, newCollege.toString());
        return repository.save(newCollege);
    }

    @GetMapping("/getCollegeByID")
    public College getCollegeByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateCollege")
    public College updateCollege(@RequestBody College newCollege) {
        return repository.save(newCollege);
    }

    @PostMapping("/deleteCollege")
    public void deleteCollege(@RequestBody College newCollege) {
        repository.delete(newCollege);
    }
}
