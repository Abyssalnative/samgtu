package com.university.university.repository;

import com.university.university.entity.Schedule;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


    List<Schedule> findByEvenOrderByPairOrder(boolean even);

    List<Schedule> findByEvenAndLessonTeacherLastName(boolean even, String lastName);

    Schedule findByEvenAndDayAndPairOrderAndLessonTeacherLastName(boolean even, int day, int pairOrder, String lastName);

    @Override
    <S extends Schedule> S saveAndFlush(S s);
}
