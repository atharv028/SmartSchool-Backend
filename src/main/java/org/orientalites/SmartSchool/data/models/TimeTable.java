package org.orientalites.SmartSchool.data.models;

import lombok.Data;

@Data
public class TimeTable {
    private int id;
    private int classId;
    private String date;
    private int subjectId;
    private int teacherId;
}
