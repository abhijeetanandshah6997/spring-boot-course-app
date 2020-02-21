package com.abhijeet.course.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    //getAllTopics()
    //getTopic(String id)
    //addTopic(Topic topic)
    //updateTopic(Topic topic)
    //deleteTopic(String id)

    List<Topic> findByCourseId(int courseId);

    @Query(value = "SELECT * FROM Topic e WHERE e.course_id = ?1 AND e.is_deleted = true", nativeQuery = true)
    List<Topic> findIsDeleted(int courseId);
}
