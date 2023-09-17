package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "exam")
public class Exam {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    public enum ExamType {
        Quiz,
        Assignment,
        Exam
    }

    @Enumerated(EnumType.STRING)
    private ExamType type;

    private String topic;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deadline;

    @Temporal(TemporalType.TIME)
    private Time startTime;

    @Temporal(TemporalType.TIME)
    private Time endTime;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "maxMarks")
    private int maxMarks;

    @ManyToOne
    @JoinColumn(name = "subject", referencedColumnName = "id")
    private Subject subject;
}
