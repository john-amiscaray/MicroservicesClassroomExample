package io.john.amiscaray.service;

import io.john.amiscaray.data.Student;
import io.john.amiscaray.data.repo.StudentRepo;
import io.john.amiscaray.dto.StudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StudentService {

    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public StudentDTO getStudentById(Long id) {
        var student = studentRepo.getReferenceById(id);

        return new StudentDTO(student);
    }

    public Long saveStudent(StudentDTO student) {
        var detachedStudent = new Student(student);

        studentRepo.save(detachedStudent);

        return detachedStudent.getId();
    }

}
