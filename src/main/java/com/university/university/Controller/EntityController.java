package com.university.university.Controller;

import com.university.university.entity.Lesson;
import com.university.university.entity.Schedule;
import com.university.university.service.LessonService;
import com.university.university.service.ScheduleService;
import com.university.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entity")
public class EntityController {

    @Autowired
    private final LessonService lessonService;

    @Autowired
    private final ScheduleService scheduleService;

    @Autowired
    private final TeacherService teacherService;

    public EntityController(LessonService lessonService, ScheduleService scheduleService, TeacherService teacherService) {
        this.lessonService = lessonService;
        this.scheduleService = scheduleService;
        this.teacherService = teacherService;
    }

    @GetMapping("/lesson")
    public List<Lesson> getLessons() {
        return lessonService.findAll();
    }

    @GetMapping("/lesson/{id}")
    public Lesson getLessonById(@PathVariable Long id){
        return lessonService.findById(id);
    }

    @GetMapping("/schedule")
    public List<Schedule> getSchedule(){ return scheduleService.findByDayAndEven();}

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public List<Lesson> getTeacher(@RequestParam String teacherName) {
        System.out.println(teacherName + " имя");
        System.out.println("name");
        return lessonService.findLessonByTeacherLastName(teacherName);
    }
}
