package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String address;
    private String phone;
}
