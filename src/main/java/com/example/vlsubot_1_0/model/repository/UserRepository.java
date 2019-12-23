package com.example.vlsubot_1_0.model.repository;

import com.example.vlsubot_1_0.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsByLogin(String login);

    boolean existsByLoginAndPassword(String login, String password);

    User findByLoginAndPasswordAndRole(String login, String password, String role);

    User findByLogin(String login);

    User getById(int id);

    User findById(int id);
}
