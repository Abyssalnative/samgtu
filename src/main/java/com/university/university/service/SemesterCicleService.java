package com.university.university.service;

import com.university.university.entity.Schedule;

public interface SemesterCicleService {


    /*
    Оставшееся количество недель
     */
    int remainingWeeks();

    /*
    Оставшееся количество пар
     */
    int remainingLesson(int lessonId);

    /*
    Когда следующая пара
     */
    Schedule nextLesson(int lessonId);

}
