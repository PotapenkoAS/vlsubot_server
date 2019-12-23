package com.example.vlsubot_1_0.model.entity;

import com.example.vlsubot_1_0.model.commonObject.DayOfWeek;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "lesson_schedule", schema = "vlsudb")
public class LessonSchedule {
    private int id;
    private String subject;
    private Enum<DayOfWeek> dayOfWeek;
    private Integer number;
    private Byte even;
    private Integer teacherId;
    private Integer roomId;
    private Collection<GroupLesson> groupLessonsById;
    private Teacher teacherByTeacherId;
    private Room roomByRoomId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "day_of_week")
    public Enum<DayOfWeek> getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Enum<DayOfWeek> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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
    @Column(name = "even")
    public Byte getEven() {
        return even;
    }

    public void setEven(Byte even) {
        this.even = even;
    }

    @Basic
    @Column(name = "teacher_id")
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonSchedule that = (LessonSchedule) o;

        if (id != that.id) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (dayOfWeek != null ? !dayOfWeek.equals(that.dayOfWeek) : that.dayOfWeek != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (even != null ? !even.equals(that.even) : that.even != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (dayOfWeek != null ? dayOfWeek.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (even != null ? even.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "lessonScheduleByLessonScheduleId")
    public Collection<GroupLesson> getGroupLessonsById() {
        return groupLessonsById;
    }

    public void setGroupLessonsById(Collection<GroupLesson> groupLessonsById) {
        this.groupLessonsById = groupLessonsById;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", updatable = false, insertable = false)
    public Teacher getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(Teacher teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
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
}
