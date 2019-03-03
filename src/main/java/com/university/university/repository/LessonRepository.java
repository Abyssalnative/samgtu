package com.university.university.repository;

import com.university.university.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson>findByTeacherLastName(String name);

    List<Lesson>findByTeacherId(long id);

    Lesson findFirstByTeacherId(long id);

    Lesson findByNameAndType(String name, String type);

    Lesson findFirstById(long id);

    @Override
    <S extends Lesson> S saveAndFlush(S s);

}
