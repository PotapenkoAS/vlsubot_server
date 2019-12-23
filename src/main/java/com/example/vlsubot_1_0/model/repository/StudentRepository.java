package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student getByDeviceId(String deviceId);
    Student getByUserId(int id);
}
