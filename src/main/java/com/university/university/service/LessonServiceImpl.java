package com.university.university.service;

import com.university.university.entity.Lesson;
import com.university.university.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonRepository lessonRepository;

    @Override
    public Lesson getLesson() {
        return null;
    }
}
