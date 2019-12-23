package com.example.vlsubot_1_0.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Department {
    private int id;
    private String shortName;
    private String fullName;
    private Integer roomId;
    private Integer instituteId;
    private Room roomByRoomId;
    private Institute instituteByInstituteId;
    private Collection<StudentGroup> groupsById;
    private Collection<Teacher> teachersById;

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
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "institute_id")
    public Integer getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (instituteId != null ? !instituteId.equals(that.instituteId) : that.instituteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (instituteId != null ? instituteId.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", updatable = false, insertable = false)
    public Room getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(Room roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "institute_id", referencedColumnName = "id", updatable = false, insertable = false)
    public Institute getInstituteByInstituteId() {
        return instituteByInstituteId;
    }

    public void setInstituteByInstituteId(Institute instituteByInstituteId) {
        this.instituteByInstituteId = instituteByInstituteId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<StudentGroup> getGroupsById() {
        return groupsById;
    }

    public void setGroupsById(Collection<StudentGroup> groupsById) {
        this.groupsById = groupsById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<Teacher> getTeachersById() {
        return teachersById;
    }

    public void setTeachersById(Collection<Teacher> teachersById) {
        this.teachersById = teachersById;
    }
}
