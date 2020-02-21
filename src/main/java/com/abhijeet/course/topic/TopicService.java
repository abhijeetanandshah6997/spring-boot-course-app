package com.abhijeet.course.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(int courseId) {
        // return topics;
        return topicRepository.findByCourseId(courseId);
    }

    public Optional<Topic> getTopic(int id) {
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public List<Topic> getDeletedTopics(int courseId) {
        return topicRepository.findIsDeleted(courseId);
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic deleteTopic(Topic topic) {
        topic.setIs_deleted(true);
        return topicRepository.save(topic);
    }
}
