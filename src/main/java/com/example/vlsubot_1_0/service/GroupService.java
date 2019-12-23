package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.entity.StudentGroup;
import com.example.vlsubot_1_0.model.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public StudentGroup getById(int id) {
        return groupRepository.getById(id);
    }
}
