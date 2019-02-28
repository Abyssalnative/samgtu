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
    public void addNewLesson(String lastNameTeacher, String lessonName, String type) {
        Lesson lesson = new Lesson();
        Teacher teacher = teacherService.findByLastName(lastNameTeacher);
        lesson.setTeacher(teacher);
        lesson.setName(lessonName);
        lesson.setType(type);
        lessonRepository.saveAndFlush(lesson);
    }

    @Override
    public Lesson findFirstByTeacherLastName(String lastName) {
        return lessonRepository.findFirstByTeacherLastName(lastName);
    }

    @Override
    public Lesson findByTeacherLastNameAndType(String lastName, String type) {
        return lessonRepository.findByTeacherLastNameAndType(lastName, type);
    }


}
