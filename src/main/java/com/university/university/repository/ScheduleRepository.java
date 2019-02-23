package com.university.university.repository;

import com.university.university.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select schedule.pair_order, lesson.name from schedule,lesson where schedule.lesson_id = lesson.id and day = :dayNum and even = :even order by pair_order")
    String getScheduleByDay(@Param("dayNum")int dayNum,@Param("even")boolean even);

}
