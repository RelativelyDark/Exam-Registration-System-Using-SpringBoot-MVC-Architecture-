package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.model.Question;
import net.javaguides.springboot.repository.CourseRepository;
import net.javaguides.springboot.util.ResponseFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
@RestController
@RequestMapping("/api/v1/")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
	@PostMapping("/register")
    public ResponseEntity<?> registerCourse(@RequestBody Course courseData) {
        Course course = new Course();
        course.setName(courseData.getName());
        course.setDescription(courseData.getDescription());
        return ResponseEntity.ok(courseRepository.save(course).build());
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/courses")
    public Long createCourse(@RequestBody Course course) {
        return courseRepository.save(course).getId();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));
        return ResponseEntity.ok(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = courseRepository.save(course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));
        courseRepository.delete(course);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/courses/send")
    public Long listCourses(@RequestBody List<Question> questions) {
        Long result = 0L;
        for (Question question : questions) {
            if (question.getQuestion() != null) {
                String Correct = question.getCorrect();
                String given = question.getGivenAnswer();
                if (Correct.equals(given)) {
                    result++;
                }
            }
        }
        return result;
    }

}
