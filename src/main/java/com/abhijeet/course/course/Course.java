package com.abhijeet.course.course;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "is_deleted != true")
public class Course {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private boolean is_deleted;

    public Course() {}

    public Course(String name, String description) {
        super();
        this.name = name;
        this.description = description;
        this.is_deleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
