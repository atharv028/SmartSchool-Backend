package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@Entity(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @OneToOne(mappedBy = "class")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private int department;

    private String semester;
    private char section;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "class", orphanRemoval = true)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Set<Teacher> teachers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "class", orphanRemoval = true)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Set<Subject> subjects;
}
