package com.university.university.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "lesson_id")
    @ManyToOne
    @JsonManagedReference
    public Lesson lesson;

    @Column
    private boolean even;

    @Column
    private int pairOrder;

    @Column
    private int day;


    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEven() {
        return even;
    }

    public void setEven(boolean even) {
        this.even = even;
    }

    public int getPairOrder() {
        return pairOrder;
    }

    public void setPairOrder(int pairOrder) {
        this.pairOrder = pairOrder;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
