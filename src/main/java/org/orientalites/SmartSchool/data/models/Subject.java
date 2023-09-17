package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "subject")
public class Subject {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String name;
    private String desc;
}
