package com.university.university.service;

import com.university.university.entity.Schedule;
import com.university.university.model.SemesterCycle;
import com.university.university.repository.ScheduleRepository;
import com.university.university.util.ValueFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private LessonService lessonService;


    @Override
    public List<Schedule> findByEven(boolean even) {
        return scheduleRepository.findByEvenOrderByPairOrder(even);
    }

    @Override
    public Schedule findNearestLesson(String name) {
        List<Schedule> schedulesCurrentWeek = scheduleRepository.findByEvenAndLessonTeacherLastName(ValueFinder.findCurrentEvenWeek(), name);
        List<Schedule> schedulesNextWeek = scheduleRepository.findByEvenAndLessonTeacherLastName(!(ValueFinder.findCurrentEvenWeek()), name);
        for (Schedule schedule : schedulesCurrentWeek) {
            if (SemesterCycle.getNowDate().get(Calendar.DAY_OF_WEEK) <= schedule.getDay()) {
                return schedule;
            }
        }
        for (Schedule schedule : schedulesNextWeek) {
            if (!(schedule == null)) {
                return schedule;
            }
        }
        for (Schedule schedule : schedulesCurrentWeek) {
            return schedule;
        }
        return null;
    }

    @Override
    public void addSchedule(boolean even, String lastName, String type, int day, int pairOrder) {
        Schedule schedule = new Schedule();
        schedule.setEven(even);
        schedule.setPairOrder(pairOrder);
        schedule.setLesson(lessonService.findFirstByTeacherLastName(lastName));
        schedule.setDay(day);
        scheduleRepository.saveAndFlush(schedule);
    }

    @Override
    public Schedule findByEvenAndDayAndPairOrderAndLessonTeacherLastName(boolean even, int day, int pairOrder, String lastName) {
        return scheduleRepository.findByEvenAndDayAndPairOrderAndLessonTeacherLastName(even, day, pairOrder, lastName);
    }
}
