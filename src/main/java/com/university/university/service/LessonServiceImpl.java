package com.university.university.service;

import com.university.university.entity.Lesson;
import com.university.university.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonRepository lessonRepository;


    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lesson> findByTeacherLastName(String lastName) {
        return lessonRepository.findByTeacherLastName(lastName);
    }

    @Override
    public List<Lesson> findLessonByTeacherLastName(String lastName) {
        return lessonRepository.findLessonByTeacher_LastName(lastName);
    }

}
