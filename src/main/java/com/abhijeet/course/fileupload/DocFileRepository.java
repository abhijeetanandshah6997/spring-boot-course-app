package com.abhijeet.course.fileupload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocFileRepository extends JpaRepository<DocFile, Integer> {
    //getAllCourses()
    //getCourse(String id)
    //addCourse(Course course)
    //updateCourse(Course course)
    //deleteCourse(String id)

    @Query(value = "SELECT * FROM DocFile e WHERE e.is_deleted = true", nativeQuery = true)
    List<DocFile> findIsDeleted();
}
