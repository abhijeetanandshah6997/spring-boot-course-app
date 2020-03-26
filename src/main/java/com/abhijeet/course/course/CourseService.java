package com.abhijeet.course.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getAllCourses(Pageable pageable) {
        // return courses;
        return courseRepository.findAll(pageable);
    }

    public Optional<Course> getCourse(int id) {
        // return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);
    }

    public List<Course> getDeletedCourses() {
        return courseRepository.findIsDeleted();
    }

    public Course addCourse(Course course) {
        // courses.add(course);
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course deleteCourse(Course course) {
        course.setIs_deleted(true);
        return courseRepository.save(course);
    }
}
