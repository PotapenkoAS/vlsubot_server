package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
