package com.university.university.service;

import com.university.university.entity.Lesson;
import com.university.university.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher getByName(int id);
    Teacher getTeacherById(int id);
    List<Teacher> getAll();
}
