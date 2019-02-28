package com.university.university.service;

import com.university.university.entity.Teacher;

import java.util.List;

public interface TeacherService {


    /**
     * Находит преподавателя
     *
     * @param lastName фамилия
     * @return преподавателя
     */
    Teacher findByLastName(String lastName);

    /**
     * Удаляет преподавателя
     *
     * @param lastName преподавателя
     */
    void deleteByLastName(String lastName);

    /**
     * Добавляет нового преподавателя
     *
     * @param firstName Имя преподавателя
     * @param lastName  Фамилия преподавателя
     */
    void addTeacher(String firstName, String lastName);

    /**
     * Находит всех преподавателей
     *
     * @return список преподавателей
     */
    List<Teacher>findAll();
}
