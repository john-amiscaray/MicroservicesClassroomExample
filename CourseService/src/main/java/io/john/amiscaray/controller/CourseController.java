package io.john.amiscaray.controller;

import io.john.amiscaray.dto.CourseDTO;
import io.john.amiscaray.dto.CoursesView;
import io.john.amiscaray.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;

    @GetMapping
    public ResponseEntity<CoursesView> getAllCourses() {
        var courses = courseService.getAllCourses();

        return ResponseEntity.ok(new CoursesView(courses));
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id) {
        var course = courseService.getCourseById(id);

        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody CourseDTO courseDTO) throws URISyntaxException {
        var savedCourseID = courseService.saveCourse(courseDTO);

        return ResponseEntity.created(new URI("/course/" + savedCourseID)).build();
    }

}
