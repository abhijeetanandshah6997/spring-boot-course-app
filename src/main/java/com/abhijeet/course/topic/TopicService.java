package com.abhijeet.course.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        // return topics;
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopic(int id) {
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public Topic addTopic(Topic topic) {
        // topics.add(topic);
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
