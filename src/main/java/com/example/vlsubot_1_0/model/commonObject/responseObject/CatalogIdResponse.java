package com.example.vlsubot_1_0.model.commonObject.responseObject;

import com.example.vlsubot_1_0.model.entity.Department;
import com.example.vlsubot_1_0.model.entity.Institute;
import com.example.vlsubot_1_0.model.entity.StudentGroup;

public class CatalogIdResponse {
    private StudentGroup group;
    private Department department;
    private Institute institute;

    public CatalogIdResponse(StudentGroup group, Department department, Institute institute) {
        this.group = group;
        this.department = department;
        this.institute = institute;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
}
