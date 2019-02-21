package com.university.university.service;

import com.university.university.entity.Teacher;
import com.university.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }



    @Override
    public Teacher getByName(int id){
        return teacherRepository.getOne(id);
    }
}
