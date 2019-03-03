package com.university.university.service;

import com.university.university.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Teacher findByLastName(String lastName);

    Teacher findById(long id);

    void addTeacher(String firstName, String lastName);

    List<Teacher>findAll();

    void deleteById(long id);
}
