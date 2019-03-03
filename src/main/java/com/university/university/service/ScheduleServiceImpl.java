package com.university.university.service;

import com.university.university.entity.Schedule;
import com.university.university.model.SemesterCycle;
import com.university.university.repository.ScheduleRepository;
import com.university.university.util.SemesterCycleUtil;
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
    public Schedule findNextLesson(long id) {
        List<Schedule> currentWeek = scheduleRepository.findByLessonIdAndEven(id,SemesterCycleUtil.findCurrentEvenWeek());
        List<Schedule> nextWeek = scheduleRepository.findByLessonIdAndEven(id,!(SemesterCycleUtil.findCurrentEvenWeek()));
        for (Schedule schedule : currentWeek) {
            if (SemesterCycle.getNowDate().get(Calendar.DAY_OF_WEEK) <= schedule.getDay()) {
                return schedule;
            }
        }
        for (Schedule schedule : nextWeek) {
            if (!(schedule == null)) {
                return schedule;
            }
        }
        for (Schedule schedule : currentWeek) {
            return schedule;
        }
        return null;
    }

    @Override
    public Schedule findSchedule(long id, boolean even, int pairOrder, int day) {
        return scheduleRepository.findByLessonIdAndEvenAndPairOrderAndDay(id,even,pairOrder,day);
    }

    @Override
    public Schedule findCopy(boolean even, int day, int pairOrder) {
        return scheduleRepository.findByEvenAndDayAndPairOrder(even,day,pairOrder);
    }

    @Override
    public Schedule saveSchedule(long lessonId, boolean even, int day, int pairOrder) {
        Schedule schedule = new Schedule(lessonService.findFirstById(lessonId),even,day,pairOrder);
        return scheduleRepository.saveAndFlush(schedule);
    }

}
