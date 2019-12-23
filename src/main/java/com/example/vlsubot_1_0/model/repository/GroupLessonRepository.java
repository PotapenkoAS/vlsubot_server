package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.GroupLesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupLessonRepository extends CrudRepository<GroupLesson, Integer> {
}
