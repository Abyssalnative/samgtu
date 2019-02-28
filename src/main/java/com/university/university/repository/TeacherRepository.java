package com.university.university.repository;

import com.university.university.entity.Teacher;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

    @Override
    <S extends Teacher> S saveAndFlush(S s);

    Teacher findFirstByLastName(String lastName);

    @Override
    <S extends Teacher> List<S> findAll(Example<S> example);

    @Transactional
    void deleteByLastName(String lastName);
}
