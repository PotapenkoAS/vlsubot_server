package com.example.vlsubot_1_0.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "student_group", schema = "vlsudb")
public class StudentGroup {
    private int id;
    private String shortName;
    private String fullName;
    private Integer number;
    private Integer departmentId;
    private Integer headTeacherId;
    private Department departmentByDepartmentId;
    private Teacher teacherByHeadTeacherId;
    private Collection<GroupLesson> groupLessonsById;
    private Collection<Student> studentsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "short_name")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "department_id")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "head_teacher_id")
    public Integer getHeadTeacherId() {
        return headTeacherId;
    }

    public void setHeadTeacherId(Integer headTeacherId) {
        this.headTeacherId = headTeacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentGroup studentGroup = (StudentGroup) o;

        if (id != studentGroup.id) return false;
        if (shortName != null ? !shortName.equals(studentGroup.shortName) : studentGroup.shortName != null) return false;
        if (fullName != null ? !fullName.equals(studentGroup.fullName) : studentGroup.fullName != null) return false;
        if (number != null ? !number.equals(studentGroup.number) : studentGroup.number != null) return false;
        if (departmentId != null ? !departmentId.equals(studentGroup.departmentId) : studentGroup.departmentId != null) return false;
        if (headTeacherId != null ? !headTeacherId.equals(studentGroup.headTeacherId) : studentGroup.headTeacherId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (headTeacherId != null ? headTeacherId.hashCode() : 0);
        return result;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "head_teacher_id", referencedColumnName = "id", updatable = false, insertable = false)
    public Teacher getTeacherByHeadTeacherId() {
        return teacherByHeadTeacherId;
    }

    public void setTeacherByHeadTeacherId(Teacher teacherByHeadTeacherId) {
        this.teacherByHeadTeacherId = teacherByHeadTeacherId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "groupByStudentGroupId")
    public Collection<GroupLesson> getGroupLessonsById() {
        return groupLessonsById;
    }

    public void setGroupLessonsById(Collection<GroupLesson> groupLessonsById) {
        this.groupLessonsById = groupLessonsById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "groupByStudentGroupId")
    public Collection<Student> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<Student> studentsById) {
        this.studentsById = studentsById;
    }
}
