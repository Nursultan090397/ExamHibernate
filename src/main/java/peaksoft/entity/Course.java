package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table (name = "courses")
@Getter
@Setter
@NoArgsConstructor

public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate creatAt;

    @ManyToMany(cascade = CascadeType.ALL)
    /*@JoinTable(name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))*/
    private List<Student> students = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, REMOVE},
            fetch = FetchType.EAGER)
    private Teacher teacher;


    public void addLessonsToCourses(Student student) {
      students.add(student);
    }

    public Course(String name, LocalDate creatAt) {
        this.name = name;
        this.creatAt = creatAt;
    }
}


