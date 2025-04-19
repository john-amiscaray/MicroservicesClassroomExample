package io.john.amiscaray.controller;

import io.john.amiscaray.dto.SaveStudentRequest;
import io.john.amiscaray.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PreAuthorize("hasAuthority('SCOPE_write:student')")
    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody SaveStudentRequest student) {
        studentService.saveStudent(student);

        return ResponseEntity.noContent().build();
    }

}
