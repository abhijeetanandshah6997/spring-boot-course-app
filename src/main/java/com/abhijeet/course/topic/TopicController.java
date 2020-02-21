package com.abhijeet.course.topic;

import java.util.List;

import com.abhijeet.course.course.Course;
import com.abhijeet.course.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses/{courseId}/topics")
    public List<Topic> getAllTopics(@PathVariable int courseId){
        return topicService.getAllTopics(courseId);
    }

    @RequestMapping("/courses/{courseId}/topics/{id}")
    public Topic getTopic(@PathVariable int courseId, @PathVariable int id){
        return topicService.getTopic(id).get();
    }

    @RequestMapping("/courses/{courseId}/topics/deleted")
    public List<Topic> getDeletedTopics(@PathVariable int courseId){
        return topicService.getDeletedTopics(courseId);
    }

    @PostMapping("/courses/{courseId}/topics")
    public Topic addTopic(@RequestBody Topic topic, @PathVariable(value = "courseId") int courseId) {
        topic.setCourse(courseService.getCourse(courseId).get());
        return topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{courseId}/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable int courseId, @PathVariable int id) {
        topic.setCourse(courseService.getCourse(courseId).get());
        if(this.getTopic(courseId, id).getId() == id ) {
            topicService.updateTopic(topic);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}/topics/{id}")
    public void deleteTopic(@PathVariable int courseId, @PathVariable int id) {
        Topic topic = this.getTopic(courseId, id);
        if(topic.getId() == id) {
            topicService.deleteTopic(topic);
        }
    }

}
