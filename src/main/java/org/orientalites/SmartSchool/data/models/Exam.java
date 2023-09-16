package org.orientalites.SmartSchool.data.models;

import lombok.Data;

@Data
public class Exam {
    private int id;
    private String type;
    private String topic;
    private String deadline;
    private String start;
    private String end;
    private String date;
    private int maxMarks;
    private int subject;
}
