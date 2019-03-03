package com.university.university.service;

import com.university.university.entity.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> findByTeacherLastName(String name);

    List<Lesson> findByTeacherId(long id);

    Lesson findFirstByTeacherId(long id);

    Lesson findByNameAndType(String name, String type);

    void addLesson(long id, String lessonName, String type);

    Lesson findFirstById(long id);

}
