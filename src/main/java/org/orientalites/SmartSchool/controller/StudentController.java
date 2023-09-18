package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.StudentRepository;
import org.orientalites.SmartSchool.data.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentRepository repository;

    public StudentController(@Autowired StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getStudents")
    public Iterable<Student> getStudents() {
        return repository.findAll();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student newStudent) {
        Logger.getGlobal().log(Level.WARNING, newStudent.toString());
        return repository.save(newStudent);
    }

    @GetMapping("/getStudentByID")
    public Student getStudentByID(String id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @PostMapping("/deleteStudent")
    public void deleteStudent(@RequestBody Student newStudent) {
        repository.delete(newStudent);
    }

    // signin and signup auth using email and password spring security

}
