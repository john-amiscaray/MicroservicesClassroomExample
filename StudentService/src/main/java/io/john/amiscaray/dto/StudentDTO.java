package io.john.amiscaray.dto;

import io.john.amiscaray.data.Student;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentDTO {

    private String name;
    private String major;
    private Float gpa;

    public StudentDTO(Student student) {
        name = student.getName();
        major = student.getMajor();
        gpa = student.getGpa();
    }

}
