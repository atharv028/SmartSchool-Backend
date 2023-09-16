package org.orientalites.SmartSchool.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class College {
    private int id;
    private String name;
    private String location;
    private String collegeID;
}
