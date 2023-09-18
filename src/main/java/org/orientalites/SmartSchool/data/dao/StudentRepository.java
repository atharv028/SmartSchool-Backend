package org.orientalites.SmartSchool.data.dao;

import java.util.Optional;
import org.orientalites.SmartSchool.data.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
    Optional<Student> findByEmail(String email);
}
