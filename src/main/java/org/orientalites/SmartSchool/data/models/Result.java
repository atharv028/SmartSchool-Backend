package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "result")
public class Result {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "exam_id",referencedColumnName = "id")
    private Exam exam;
    @OneToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;
    private int marks;
}
