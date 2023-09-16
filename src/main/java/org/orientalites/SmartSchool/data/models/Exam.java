package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

enum ExamType {
    Quiz,Assignment,Exam
}

@Data
@NoArgsConstructor
@Entity(name = "exam")
public class Exam {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private ExamType type;
    private String topic;
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Temporal(TemporalType.TIME)
    private Time startTime;
    @Temporal(TemporalType.TIME)
    private Time endTime;
    private String date;
    private int maxMarks;
    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;
}
