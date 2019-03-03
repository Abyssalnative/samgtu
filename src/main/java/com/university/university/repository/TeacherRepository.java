package com.university.university.repository;

import com.university.university.entity.Teacher;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Override
    <S extends Teacher> S saveAndFlush(S s);

    @Override
    <S extends Teacher> List<S> findAll(Example<S> example);

    Teacher findById(long id);

    Teacher findFirstByLastName(String lastName);

    @Override
    void deleteById(Long aLong);
}
