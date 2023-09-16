package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "attendance")
public class Attendance {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @OneToOne()
    @JoinColumn(name = "student", referencedColumnName = "id")
    private Student student;

    @Temporal(TemporalType.DATE)
    private Date date;

    private boolean present;
}
