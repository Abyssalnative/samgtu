package com.university.university.repository;

import com.university.university.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {


    List<Lesson>findByTeacherLastName(String name);

    Lesson findFirstByTeacherLastName(String lastName);

    Lesson findByTeacherLastNameAndType(String lastName,String type);

    @Override
    <S extends Lesson> S saveAndFlush(S s);

}
