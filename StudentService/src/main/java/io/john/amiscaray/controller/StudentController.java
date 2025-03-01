package io.john.amiscaray.controller;

import io.john.amiscaray.dto.CourseSaveStudentRequest;
import io.john.amiscaray.dto.StudentDTO;
import io.john.amiscaray.dto.StudentsView;
import io.john.amiscaray.http.CourseServiceClient;
import io.john.amiscaray.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;
    private CourseServiceClient courseServiceClient;

    @GetMapping("")
    public ResponseEntity<StudentsView> getAllStudents() {
        var students = studentService.getAllStudents()
                .stream()
                .map(StudentDTO::new)
                .toList();

        return ResponseEntity.ok(new StudentsView(students));
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable(value = "id") long id) {
        var student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    @PostMapping("")
    public ResponseEntity<Void> saveStudent(@RequestBody StudentDTO studentDTO) throws URISyntaxException {
        var studentID = studentService.saveStudent(studentDTO);

        courseServiceClient.saveNewStudent(new CourseSaveStudentRequest(studentID))
                .then()
                .subscribe(_result -> System.out.println("Hello World"));

        return ResponseEntity.created(new URI("/student/" + studentID)).build();
    }

}
