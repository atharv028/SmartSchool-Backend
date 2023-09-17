package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.AttendenceRepository;
import org.orientalites.SmartSchool.data.models.Attendence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttendenceController {

    private final AttendenceRepository repository;

    public AttendenceController(@Autowired AttendenceRepository attendenceRepository) {
        this.repository = attendenceRepository;
    }

    @GetMapping("/getAttendences")
    public Iterable<Attendence> getAttendences() {
        return repository.findAll();
    }

    @PostMapping("/addAttendence")
    public Attendence addAttendence(@RequestBody Attendence newAttendence) {
        Logger.getGlobal().log(Level.WARNING, newAttendence.toString());
        return repository.save(newAttendence);
    }

    @GetMapping("/getAttendenceByID")
    public Attendence getAttendenceByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateAttendence")
    public Attendence updateAttendence(@RequestBody Attendence newAttendence) {
        return repository.save(newAttendence);
    }

    @PostMapping("/deleteAttendence")
    public void deleteAttendence(@RequestBody Attendence newAttendence) {
        repository.delete(newAttendence);
    }
}
