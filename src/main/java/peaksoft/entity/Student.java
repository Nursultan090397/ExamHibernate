package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @ManyToMany(cascade = {DETACH, MERGE,PERSIST}, fetch = FetchType.LAZY,mappedBy = "students")
    private List<Course> course = new ArrayList<>();

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}