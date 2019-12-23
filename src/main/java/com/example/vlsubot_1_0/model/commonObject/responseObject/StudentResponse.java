package com.example.vlsubot_1_0.model.commonObject.responseObject;

import com.example.vlsubot_1_0.model.entity.Student;

public class StudentResponse {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Integer groupId;
    private Integer instituteId;
    private Integer departmentId;
    private Integer userId;

    public StudentResponse() {
    }

    public StudentResponse(Integer id, String login, String password, Student student, Integer departmentId, Integer instituteId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.patronymic = student.getPatronymic();
        this.groupId = student.getGroupId();
        this.userId = student.getUserId();
        this.departmentId = departmentId;
        this.instituteId = instituteId;
    }


    public StudentResponse(Student student, Integer departmentId, Integer instituteId) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.patronymic = student.getPatronymic();
        this.groupId = student.getGroupId();
        this.userId = student.getUserId();
        this.departmentId = departmentId;
        this.instituteId = instituteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
