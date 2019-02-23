package com.university.university.service;

import com.university.university.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;


    @Override
    public String getScheduleByDay() {
        return scheduleRepository.getScheduleByDay(1,true);
    }
}
