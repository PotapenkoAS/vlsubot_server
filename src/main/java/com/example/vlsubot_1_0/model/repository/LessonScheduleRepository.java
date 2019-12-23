package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.LessonSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonScheduleRepository extends CrudRepository<LessonSchedule,Integer> {
}
