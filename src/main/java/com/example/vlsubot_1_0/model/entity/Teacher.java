package com.example.vlsubot_1_0.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String rank;
    private Integer departmentId;
    private Collection<StudentGroup> groupsById;
    private Collection<LessonSchedule> lessonSchedulesById;
    private Department departmentByDepartmentId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "department_id")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (firstName != null ? !firstName.equals(teacher.firstName) : teacher.firstName != null) return false;
        if (lastName != null ? !lastName.equals(teacher.lastName) : teacher.lastName != null) return false;
        if (patronymic != null ? !patronymic.equals(teacher.patronymic) : teacher.patronymic != null) return false;
        if (rank != null ? !rank.equals(teacher.rank) : teacher.rank != null) return false;
        if (departmentId != null ? !departmentId.equals(teacher.departmentId) : teacher.departmentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "teacherByHeadTeacherId")
    public Collection<StudentGroup> getGroupsById() {
        return groupsById;
    }

    public void setGroupsById(Collection<StudentGroup> groupsById) {
        this.groupsById = groupsById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "teacherByTeacherId")
    public Collection<LessonSchedule> getLessonSchedulesById() {
        return lessonSchedulesById;
    }

    public void setLessonSchedulesById(Collection<LessonSchedule> lessonSchedulesById) {
        this.lessonSchedulesById = lessonSchedulesById;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", updatable = false, insertable = false)
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }
}
