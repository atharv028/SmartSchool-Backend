package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.TimeTableRepository;
import org.orientalites.SmartSchool.data.models.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TimeTableController {
    private final TimeTableRepository repository;

    public TimeTableController(@Autowired TimeTableRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getTimeTables")
    public Iterable<TimeTable> getTimeTables() {
        return repository.findAll();
    }

    @PostMapping("/addTimeTable")
    public TimeTable addTimeTable(@RequestBody TimeTable newTimeTable) {
        Logger.getGlobal().log(Level.WARNING, newTimeTable.toString());
        return repository.save(newTimeTable);
    }

    @GetMapping("/getTimeTableByID")
    public TimeTable getTimeTableByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateTimeTable")
    public TimeTable updateTimeTable(@RequestBody TimeTable newTimeTable) {
        return repository.save(newTimeTable);
    }

    @PostMapping("/deleteTimeTable")
    public void deleteTimeTable(@RequestBody TimeTable newTimeTable) {
        repository.delete(newTimeTable);
    }
}
