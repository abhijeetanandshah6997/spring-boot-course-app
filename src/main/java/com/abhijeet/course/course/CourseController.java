package com.abhijeet.course.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.getCourse(id).get();
    }

    @RequestMapping("/courses/deleted")
    public List<Course> getDeletedCourses(){
        return courseService.getDeletedCourses();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable int id) {
        if(this.getCourse(id).getId() == id) {
            courseService.updateCourse(course);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        Course course = this.getCourse(id);
        if(course.getId() == id) {
            courseService.deleteCourse(course);
        }
    }

}
