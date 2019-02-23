package com.university.university.service;

import com.university.university.entity.Lesson;

import java.util.List;

public interface LessonService {


    /**
     * Находит все пары
     *
     * @return список пар
     */
    List<Lesson> findAll();

    /**
     * Находит пару по id
     *
     * @param id id занятия
     * @return занятие
     */
    Lesson findById(Long id);

}
