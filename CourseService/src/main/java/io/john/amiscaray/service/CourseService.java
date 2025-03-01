package io.john.amiscaray.service;

import io.john.amiscaray.data.Course;
import io.john.amiscaray.data.repo.CourseRepo;
import io.john.amiscaray.dto.CourseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CourseService {

    private CourseRepo courseRepo;

    public List<CourseDTO> getAllCourses() {
        var courses = courseRepo.findAll();

        return courses.stream()
                .map(CourseDTO::new)
                .toList();
    }

    public CourseDTO getCourseById(Long id) {
        var course = courseRepo.findById(id).orElseThrow();

        return new CourseDTO(course);
    }

    public Long saveCourse(CourseDTO courseDTO) {
        var detachedCourse = new Course(courseDTO);

        return courseRepo.save(detachedCourse).getId();
    }

}
