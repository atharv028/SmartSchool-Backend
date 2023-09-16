package org.orientalites.SmartSchool.data.models;

import lombok.Data;

@Data
public class Attendance {
    private int id;
    private int student;
    private String date;
    private boolean present;
}
