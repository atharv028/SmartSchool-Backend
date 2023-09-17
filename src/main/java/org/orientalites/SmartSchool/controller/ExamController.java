package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.ExamRepository;
import org.orientalites.SmartSchool.data.models.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ExamController {
    private final ExamRepository repository;

    public ExamController(@Autowired ExamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getExams")
    public Iterable<Exam> getExams() {
        return repository.findAll();
    }

    @PostMapping("/addExam")
    public Exam addExam(@RequestBody Exam newExam) {
        Logger.getGlobal().log(Level.WARNING, newExam.toString());
        return repository.save(newExam);
    }

    @GetMapping("/getExamByID")
    public Exam getExamByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateExam")
    public Exam updateExam(@RequestBody Exam newExam) {
        return repository.save(newExam);
    }

    @PostMapping("/deleteExam")
    public void deleteExam(@RequestBody Exam newExam) {
        repository.delete(newExam);
    }
}
