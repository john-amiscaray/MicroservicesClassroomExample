package io.john.amiscaray.data;

import io.john.amiscaray.dto.StudentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String major;
    private Float gpa;

    public Student(StudentDTO studentDTO) {
        name = studentDTO.getName();
        major = studentDTO.getMajor();
        gpa = studentDTO.getGpa();
    }

}
