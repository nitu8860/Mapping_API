package com.example.Mapping_API.service;

import com.example.Mapping_API.model.Course;
import com.example.Mapping_API.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setTitle(updatedCourse.getTitle());
            existingCourse.setDescription(updatedCourse.getDescription());
            existingCourse.setDuration(updatedCourse.getDuration());
            existingCourse.setStudentList(updatedCourse.getStudentList());
            return courseRepository.save(existingCourse);
        } else {
            return null;
        }
    }

    public boolean deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.delete(course);
            return true;
        } else {
            return false;
        }
    }
}
