package com.university.university.service;

import com.university.university.entity.Lesson;
import com.university.university.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleService scheduleService;

    @Override
    public List<Lesson> getDay(int day, boolean even) {
        return null;
    }

    @Override
    public Schedule getNextLessonDay() {
        return null;
    }
}
