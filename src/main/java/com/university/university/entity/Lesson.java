package com.university.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "lesson")
public class Lesson {

    @JoinColumn(name = "Teacher_id")
    @OneToOne
    private Teacher teacher;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String type;

    @Id
    private int id;

    public Lesson(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
