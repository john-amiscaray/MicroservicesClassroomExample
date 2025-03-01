package io.john.amiscaray.dto;

import io.john.amiscaray.data.Course;
import io.john.amiscaray.data.CourseTerm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CourseDTO {

    private Long id;
    private String name;
    private CourseTerm term;

    public CourseDTO(Course course) {
        id = course.getId();
        name = course.getName();
        term = course.getTerm();
    }

}
