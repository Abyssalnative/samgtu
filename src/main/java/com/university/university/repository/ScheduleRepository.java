package com.university.university.repository;

import com.university.university.entity.Schedule;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Override
    <S extends Schedule> S saveAndFlush(S s);

    List<Schedule> findByEvenOrderByPairOrder(boolean even);

    List<Schedule> findByLessonIdAndEven(long id, boolean even);

    Schedule findByLessonIdAndEvenAndPairOrderAndDay(long id, boolean even, int pairOrder, int day);

    Schedule findByEvenAndDayAndPairOrder(boolean even, int day, int pairOrder);

}
