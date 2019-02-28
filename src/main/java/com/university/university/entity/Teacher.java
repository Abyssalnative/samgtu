package com.university.university.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Column(name = "last_name", nullable = false)
    @Id
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Lesson> lesson;


    public Set<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(Set<Lesson> lesson) {
        this.lesson = lesson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
