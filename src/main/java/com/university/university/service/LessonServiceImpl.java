package com.university.university.service;

import com.university.university.entity.Lesson;
import com.university.university.entity.Teacher;
import com.university.university.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private TeacherService teacherService;


    @Override
    public List<Lesson> findByTeacherLastName(String name) {
        return lessonRepository.findByTeacherLastName(name);
    }

    @Override
    public List<Lesson> findByTeacherId(long id) {
        return lessonRepository.findByTeacherId(id);
    }

    @Override
    public Lesson findFirstByTeacherId(long id) {
        return lessonRepository.findFirstByTeacherId(id);
    }

    @Override
    public Lesson findByNameAndType(String name, String type) {
        return lessonRepository.findByNameAndType(name,type);
    }

    @Override
    public void addLesson(long id, String lessonName, String type) {
        Lesson lesson = new Lesson();
        Teacher teacher = teacherService.findById(id);
        lesson.setTeacher(teacher);
        lesson.setName(lessonName);
        lesson.setType(type);
        lessonRepository.saveAndFlush(lesson);
    }

    @Override
    public Lesson findFirstById(long id) {
        return lessonRepository.findFirstById(id);
    }
}
