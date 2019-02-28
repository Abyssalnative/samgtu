package com.university.university.service;

import com.university.university.entity.Lesson;

import java.util.List;

public interface LessonService {


    /**
     * Находит название занятия по имени преподавателя
     *
     * @param name фамилия преподавателя
     * @return занятие
     */
    List<Lesson> findByTeacherLastName(String name);

    /**
     * Добавляет новый пердмет
     *
     * @param teacherLastName фамилия учителя
     * @param lessonName      название предмета
     * @param type            тип предмета
     */
    void addNewLesson(String teacherLastName, String lessonName, String type);

    /**
     * Находит один предмет преподавателя
     *
     * @param lastName фамилия преподавателя
     * @return
     */
    Lesson findFirstByTeacherLastName(String lastName);

    /**
     * Находит преподавателя
     *
     * @param lastName фамилия преподавателя
     * @param type     тип предмета
     * @return преподавателя
     */
    Lesson findByTeacherLastNameAndType(String lastName, String type);
}
