package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.ResultRepository;
import org.orientalites.SmartSchool.data.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    private final ResultRepository repository;

    public ResultController(@Autowired ResultRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getResults")
    public Iterable<Result> getResults() {
        return repository.findAll();
    }

    @PostMapping("/addResult")
    public Result addResult(@RequestBody Result newResult) {
        Logger.getGlobal().log(Level.WARNING, newResult.toString());
        return repository.save(newResult);
    }

    @GetMapping("/getResultByID")
    public Result getResultByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateResult")
    public Result updateResult(@RequestBody Result newResult) {
        return repository.save(newResult);
    }

    @PostMapping("/deleteResult")
    public void deleteResult(@RequestBody Result newResult) {
        repository.delete(newResult);
    }
}
