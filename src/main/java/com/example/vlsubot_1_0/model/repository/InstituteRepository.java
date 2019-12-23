package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.Institute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituteRepository extends CrudRepository<Institute, Integer> {

    List<Institute> findAll();

    Institute getById(int id);
}
