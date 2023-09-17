package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "timetable")
public class TimeTable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @OneToOne()
    @JoinColumn(name = "class", referencedColumnName = "id")
    private Class classId;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;

    @OneToOne()
    @JoinColumn(name = "subject", referencedColumnName = "id")
    private Subject subjectId;

    @OneToOne()
    @JoinColumn(name = "teacher", referencedColumnName = "id")
    private Teacher teacherId;
}
