package com.university.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @JoinColumn(name = "Lesson_Id")
    @OneToOne
    private Lesson lesson;

    @Column(name = "Even")
    private boolean Even;

    @Column(name = "Day")
    private int day;

    @Column(name = "Pair_Order")
    private int pairOrder;

    @Id
    @GeneratedValue
    private int id;

    public Schedule(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public boolean isEven() {
        return Even;
    }

    public void setEven(boolean even) {
        Even = even;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPairOrder() {
        return pairOrder;
    }

    public void setPairOrder(int pairOrder) {
        this.pairOrder = pairOrder;
    }
}
