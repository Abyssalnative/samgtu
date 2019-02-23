package com.university.university.repository;

import com.university.university.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select schedule.pair_order, lesson.name from schedule,lesson where schedule.lesson_id = lesson.id and day = :dayNum and even = :even order by pair_order")
    List<Schedule> findByDayAndEven(int day, boolean even);

}
