package org.orientalites.SmartSchool.data.models;

import lombok.Data;

@Data
public class Teacher {
    private int id;
    private String name;
    private String qualifications;
    private String address;
    private String phone;
    private String joining;
}
