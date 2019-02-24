package com.university.university.repository;

import com.university.university.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByTeacherLastName(String lastName);
    List<Lesson> findLessonByTeacher_LastName(String lastName);
}
