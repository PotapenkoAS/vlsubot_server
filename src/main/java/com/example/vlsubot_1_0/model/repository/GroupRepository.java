package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<StudentGroup, Integer> {

    StudentGroup getByShortName(String shortName);

    StudentGroup getById(Integer id);
}
