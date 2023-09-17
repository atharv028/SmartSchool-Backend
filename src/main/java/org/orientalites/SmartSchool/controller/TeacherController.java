package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.TeacherRepository;
import org.orientalites.SmartSchool.data.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TeacherController {
    private final TeacherRepository repository;

    public TeacherController(@Autowired TeacherRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getTeachers")
    public Iterable<Teacher> getTeachers() {
        return repository.findAll();
    }

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher newTeacher) {
        Logger.getGlobal().log(Level.WARNING, newTeacher.toString());
        return repository.save(newTeacher);
    }

    @GetMapping("/getTeacherByID")
    public Teacher getTeacherByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher newTeacher) {
        return repository.save(newTeacher);
    }

    @PostMapping("/deleteTeacher")
    public void deleteTeacher(@RequestBody Teacher newTeacher) {
        repository.delete(newTeacher);
    }
}
