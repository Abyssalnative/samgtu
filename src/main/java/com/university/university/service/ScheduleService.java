package com.university.university.service;

import com.university.university.entity.Lesson;
import com.university.university.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    /*
    return list of lessons
     */
    List<Lesson> getDay(int day, boolean even);


    /*
    вычисление близжайшего учебного дня

    return formatted next day
     */
    Schedule getNextLessonDay();




}
