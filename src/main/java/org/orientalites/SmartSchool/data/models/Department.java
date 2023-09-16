package org.orientalites.SmartSchool.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "department")
public class Department {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", referencedColumnName = "id")
    private College college;
}
