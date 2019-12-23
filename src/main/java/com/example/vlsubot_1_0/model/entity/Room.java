package com.example.vlsubot_1_0.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Room {
    private int id;
    private String code;
    private String type;
    private Collection<Department> departmentsById;
    private Collection<LessonSchedule> lessonSchedulesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (code != null ? !code.equals(room.code) : room.code != null) return false;
        if (type != null ? !type.equals(room.type) : room.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<Department> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<Department> departmentsById) {
        this.departmentsById = departmentsById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<LessonSchedule> getLessonSchedulesById() {
        return lessonSchedulesById;
    }

    public void setLessonSchedulesById(Collection<LessonSchedule> lessonSchedulesById) {
        this.lessonSchedulesById = lessonSchedulesById;
    }
}
