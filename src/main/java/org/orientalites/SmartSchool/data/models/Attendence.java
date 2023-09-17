package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "attendence")
public class Attendence {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @OneToOne()
    @JoinColumn(name = "student", referencedColumnName = "id")
    private Student student;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;

    private boolean present;
}
