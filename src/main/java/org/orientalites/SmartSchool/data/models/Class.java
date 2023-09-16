package org.orientalites.SmartSchool.data.models;

import lombok.Data;

@Data
public class Class {
    private int id;
    private int department;
    private String semester;
    private char section;
    private int teachers;
    private int subjects;
}
