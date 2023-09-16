package org.orientalites.SmartSchool.data.models;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String email;
    private String password;
    private String name;
    private int classId;
    private String dob;
    private String address;
    private String phone;
}
