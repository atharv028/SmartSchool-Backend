package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "teacher")
public class Teacher {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String name;
    private String qualifications;
    private String address;
    private Boolean sex;
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp joining;
}
