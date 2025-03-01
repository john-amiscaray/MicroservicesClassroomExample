package io.john.amiscaray.service;

import io.john.amiscaray.data.Student;
import io.john.amiscaray.data.repo.StudentRepo;
import io.john.amiscaray.dto.SaveStudentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class StudentService {

    private StudentRepo studentRepo;

    public void saveStudent(SaveStudentRequest saveStudentRequest) {
        var detachedStudent = new Student(saveStudentRequest);

        studentRepo.save(detachedStudent);
    }

}
