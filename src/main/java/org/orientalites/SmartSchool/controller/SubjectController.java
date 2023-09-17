package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.SubjectRepository;
import org.orientalites.SmartSchool.data.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SubjectController {
    private final SubjectRepository repository;

    public SubjectController(@Autowired SubjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getSubjects")
    public Iterable<Subject> getSubjects() {
        return repository.findAll();
    }

    @PostMapping("/addSubject")
    public Subject addSubject(@RequestBody Subject newSubject) {
        Logger.getGlobal().log(Level.WARNING, newSubject.toString());
        return repository.save(newSubject);
    }

    @GetMapping("/getSubjectByID")
    public Subject getSubjectByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateSubject")
    public Subject updateSubject(@RequestBody Subject newSubject) {
        return repository.save(newSubject);
    }

    @PostMapping("/deleteSubject")
    public void deleteSubject(@RequestBody Subject newSubject) {
        repository.delete(newSubject);
    }
}
