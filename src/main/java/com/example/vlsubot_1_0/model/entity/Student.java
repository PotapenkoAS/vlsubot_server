package com.example.vlsubot_1_0.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Integer groupId;
    private Integer userId;
    private StudentGroup groupByStudentGroupId;
    private User userByUserId;
    private String deviceId;

    public Student() {
    }

    public Student(String firstName, String lastName, String patronymic, Integer groupId, Integer userId, String deviceId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.groupId = groupId;
        this.userId = userId;
        this.deviceId = deviceId;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "group_id")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (userId != student.userId) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (patronymic != null ? !patronymic.equals(student.patronymic) : student.patronymic != null) return false;
        if (groupId != null ? !groupId.equals(student.groupId) : student.groupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", updatable = false, insertable = false)
    public StudentGroup getGroupByStudentGroupId() {
        return groupByStudentGroupId;
    }

    public void setGroupByStudentGroupId(StudentGroup groupByStudentGroupId) {
        this.groupByStudentGroupId = groupByStudentGroupId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Basic
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
