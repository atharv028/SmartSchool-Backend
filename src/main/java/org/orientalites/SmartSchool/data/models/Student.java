package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "student")
public class Student {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class", referencedColumnName = "id")
    private Class classId;

    private Boolean sex;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dob;

    private String address;
    private String phone;
}
