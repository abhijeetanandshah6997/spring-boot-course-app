package com.abhijeet.course.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    //getAllCourses()
    //getCourse(String id)
    //addCourse(Course course)
    //updateCourse(Course course)
    //deleteCourse(String id)

    @Query(value = "SELECT * FROM Course e WHERE e.is_deleted = true", nativeQuery = true)
    List<Course> findIsDeleted();
}
