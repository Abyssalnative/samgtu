package com.university.university.service;

import com.university.university.entity.Teacher;
import com.university.university.repository.LessonRepository;
import com.university.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public Teacher findByLastName(String lastName) {
        return teacherRepository.findFirstByLastName(lastName);
    }

    @Override
    public void deleteByLastName(String lastName) {
        teacherRepository.deleteByLastName(lastName);
    }

    @Override
    public void addTeacher(String firstName, String lastName) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
