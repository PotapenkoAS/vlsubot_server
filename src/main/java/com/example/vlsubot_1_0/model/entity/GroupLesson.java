package com.example.vlsubot_1_0.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "group_lesson", schema = "vlsudb", catalog = "")
public class GroupLesson {
    private int id;
    private int groupId;
    private int lessonScheduleId;
    private StudentGroup groupByStudentGroupId;
    private LessonSchedule lessonScheduleByLessonScheduleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "lesson_schedule_id")
    public int getLessonScheduleId() {
        return lessonScheduleId;
    }

    public void setLessonScheduleId(int lessonScheduleId) {
        this.lessonScheduleId = lessonScheduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupLesson that = (GroupLesson) o;

        if (id != that.id) return false;
        if (groupId != that.groupId) return false;
        if (lessonScheduleId != that.lessonScheduleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + groupId;
        result = 31 * result + lessonScheduleId;
        return result;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public StudentGroup getGroupByStudentGroupId() {
        return groupByStudentGroupId;
    }

    public void setGroupByStudentGroupId(StudentGroup groupByStudentGroupId) {
        this.groupByStudentGroupId = groupByStudentGroupId;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lesson_schedule_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public LessonSchedule getLessonScheduleByLessonScheduleId() {
        return lessonScheduleByLessonScheduleId;
    }

    public void setLessonScheduleByLessonScheduleId(LessonSchedule lessonScheduleByLessonScheduleId) {
        this.lessonScheduleByLessonScheduleId = lessonScheduleByLessonScheduleId;
    }
}
