package org.orientalites.SmartSchool.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.orientalites.SmartSchool.data.dao.DepartmentRepository;
import org.orientalites.SmartSchool.data.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(@Autowired DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getDepartments")
    public Iterable<Department> getDepartments() {
        return repository.findAll();
    }

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department newDepartment) {
        Logger.getGlobal().log(Level.WARNING, newDepartment.toString());
        return repository.save(newDepartment);
    }

    @GetMapping("/getDepartmentByID")
    public Department getDepartmentByID(int id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @PostMapping("/updateDepartment")
    public Department updateDepartment(@RequestBody Department newDepartment) {
        return repository.save(newDepartment);
    }

    @PostMapping("/deleteDepartment")
    public void deleteDepartment(@RequestBody Department newDepartment) {
        repository.delete(newDepartment);
    }
}
