package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    Department getById(Integer id);
}
