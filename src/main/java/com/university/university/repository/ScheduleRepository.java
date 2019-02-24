package com.university.university.repository;

import com.university.university.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByDayAndEven(int day, boolean even);

}
