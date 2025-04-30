package com.example.backend.service;

import com.example.backend.model.Course;
import com.example.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;



    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }



    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
    

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Long id, Course courseDetails) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    existingCourse.setTitle(courseDetails.getTitle());
                    existingCourse.setCourseCode(courseDetails.getCourseCode());
                    existingCourse.setTeacher(courseDetails.getTeacher());
                    return courseRepository.save(existingCourse);
                });
    }

    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 