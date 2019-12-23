package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.commonObject.responseObject.StudentResponse;
import com.example.vlsubot_1_0.model.entity.Student;
import com.example.vlsubot_1_0.model.entity.StudentGroup;
import com.example.vlsubot_1_0.model.repository.DepartmentRepository;
import com.example.vlsubot_1_0.model.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private DepartmentRepository departmentRepository;
    private GroupRepository groupRepository;

    @Autowired
    public Mapper(DepartmentRepository departmentRepository, GroupRepository groupRepository) {
        this.departmentRepository = departmentRepository;
        this.groupRepository = groupRepository;
    }

    public StudentResponse studentToStudentResponse(Integer id, String login, String password, Student student, Integer departmentId) {
        if (departmentId == null) {
            departmentId = groupRepository.getById(student.getGroupId()).getDepartmentId();
        }
        int instituteId = departmentRepository.getById(departmentId).getInstituteId();
        return new StudentResponse(
                id,
                login,
                password,
                student,
                departmentId,
                instituteId
        );
    }
}
