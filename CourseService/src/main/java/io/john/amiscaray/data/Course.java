package io.john.amiscaray.data;

import io.john.amiscaray.dto.CourseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private CourseTerm term;
    @ManyToMany
    @JoinTable(
            name = "StudentCourse",
            joinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id")
            }
    )
    private List<Student> takenBy;

    public Course(CourseDTO courseDTO) {
        name = courseDTO.getName();
        term = courseDTO.getTerm();
        takenBy = new ArrayList<>();
    }

}
