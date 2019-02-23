package com.university.university.service;


import com.university.university.entity.Lesson;
import com.university.university.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> findByDayAndEven();

}
