package org.orientalites.SmartSchool.data.dao;

import org.orientalites.SmartSchool.data.models.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {}
