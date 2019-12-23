package com.example.vlsubot_1_0.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Institute {
    private int id;
    private String shortName;
    private String fullName;
    private Collection<Department> departmentsById;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Institute institute = (Institute) o;

        if (id != institute.id) return false;
        if (shortName != null ? !shortName.equals(institute.shortName) : institute.shortName != null) return false;
        if (fullName != null ? !fullName.equals(institute.fullName) : institute.fullName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "instituteByInstituteId")
    public Collection<Department> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<Department> departmentsById) {
        this.departmentsById = departmentsById;
    }

}
