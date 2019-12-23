package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.entity.Department;
import com.example.vlsubot_1_0.model.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getById(int id) {
        return departmentRepository.getById(id);
    }
}
