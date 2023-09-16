package org.orientalites.SmartSchool.data.dao;

import org.orientalites.SmartSchool.data.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {}
