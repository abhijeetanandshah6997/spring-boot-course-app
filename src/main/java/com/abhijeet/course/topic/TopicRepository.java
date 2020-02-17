package com.abhijeet.course.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    //getAllTopics()
    //getTopic(String id)
    //addTopic(Topic topic)
    //updateTopic(Topic topic)
    //deleteTopic(String id)
}
