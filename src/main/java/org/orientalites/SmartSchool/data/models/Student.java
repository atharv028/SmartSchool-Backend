package org.orientalites.SmartSchool.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "student")
public class Student {
    @jakarta.persistence.Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String password;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "class", referencedColumnName = "id")
    @JsonIgnore
    private Class classId;

    private Boolean sex;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dob;

    private String address;
    private String phone;
}
