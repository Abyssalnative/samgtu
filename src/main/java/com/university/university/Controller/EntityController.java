package com.university.university.Controller;

import com.university.university.entity.Lesson;
import com.university.university.entity.Schedule;
import com.university.university.entity.Teacher;
import com.university.university.service.LessonService;
import com.university.university.service.ScheduleService;
import com.university.university.service.TeacherService;
import com.university.university.util.ValueFinder;
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

    /**
     * Находит близжайшую пару
     *
     * @param name фамилия преподавателя
     * @return объект расписания
     */
    @RequestMapping(value = "/lesson/nearest")
    public Schedule findNearestLesson(@RequestParam String name) {
        return scheduleService.findNearestLesson(name);
    }

    /**
     * Добавляет нового преподавателя
     *
     * @param firstName имя
     * @param lastName фамилия
     * @return статус процедуры
     */
    @RequestMapping(value = "/teacher/save")
    public String addNewTeacher(@RequestParam String firstName, @RequestParam String lastName) {
        if (teacherService.findByLastName(lastName)!=null){
            return "Такой преподаватель уже существует";
        }
        teacherService.addTeacher(firstName, lastName);
        if (teacherService.findByLastName(lastName) != null) {
            return "Преподаватель успешно добавлен";
        } else {
            return "Ошибка добавления";
        }
    }

    /**
     * Добавляет новый предмет
     *
     * @param teacherLastName фамилия преподователя
     * @param lessonName      название предмета
     * @param type            тип предмета
     * @return статус процедуры
     */
    @RequestMapping(value = "/lesson/save")
    public String addNewLesson(@RequestParam(value = "teacherName") String teacherLastName, @RequestParam String lessonName, @RequestParam String type) {
        if(lessonService.findByTeacherLastNameAndType(teacherLastName,type)!=null){
            return "Такой предмет уже существует";
        }
        lessonService.addNewLesson(teacherLastName, lessonName, type);
        if (lessonService.findByTeacherLastNameAndType(teacherLastName, type) != null) {
            return "Предмет успешно добавлен";
        } else {
            return "Ошибка добавления";
        }
    }

    /**
     * Находит предмет по фамилии учителя
     *
     * @param lastName фамилия учителя
     * @return предмет
     */
    @RequestMapping(value = "/lesson")
    public Lesson getLessonByTeacherName(@RequestParam String lastName) {
        return lessonService.findFirstByTeacherLastName(lastName);
    }

    /**
     * Находит расписание предметов на текущую неделю
     *
     * @return расписание предметов
     */
    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public List<Schedule> getScheduleEven() {
        return scheduleService.findByEven(ValueFinder.findCurrentEvenWeek());
    }

    /**
     * Находи расписание следующей недели
     *
     * @return расписани не текущей недели
     */
    @RequestMapping(value = "/schedule/full")
    public List<Schedule> getFullSchedule() {
        return scheduleService.findByEven(!(ValueFinder.findCurrentEvenWeek()));
    }

    /**
     * Добавляет новую позицию в расписание
     *
     * @param even            четность недели
     * @param teacherLastName фамилию преподавателя
     * @param type            тип предмета
     * @param day             день недели
     * @param pairOrder       какая по счету пара
     * @return статус процедуры
     */
    @RequestMapping(value = "/schedule/save", method = RequestMethod.GET)
    public String addNewSchedule(@RequestParam(value = "even") String even, @RequestParam(value = "teacherName") String teacherLastName, @RequestParam(value = "type") String type, @RequestParam(value = "dayOfWeek") int day, @RequestParam(value = "pairOrder") int pairOrder) {
        boolean evenB;
        if (even.equalsIgnoreCase("Четная")) {
            evenB = true;
        } else {
            evenB = false;
        }
        if(scheduleService.findByEvenAndDayAndPairOrderAndLessonTeacherLastName(evenB, day, pairOrder, teacherLastName)!=null){
            return "Такая позиция в расписания уже существует";
        }
        scheduleService.addSchedule(evenB, teacherLastName, type, day, pairOrder);
        if (scheduleService.findByEvenAndDayAndPairOrderAndLessonTeacherLastName(evenB, day, pairOrder, teacherLastName) != null) {
            return "Позиция успешно добавлена";
        } else {
            return "Ошибка в добавления";
        }
    }

    /**
     * Находит всех преподавателей
     *
     * @return список преподавателей
     */
    @RequestMapping(value = "/teacher/select")
    public List<Teacher> findAllTeachers() {
        return teacherService.findAll();
    }

    /**
     * Находит тип предметов
     *
     * @param lastName фамилия преподавателя
     * @return список предметов
     */
    @RequestMapping(value = "lesson/select")
    public List<Lesson> findTypeByTeacherLastName(@RequestParam String lastName) {
        return lessonService.findByTeacherLastName(lastName);
    }

    /**
     * Удалеяет преподавателя
     *
     * @param lastName фамилия преподавателя
     * @return статус процедуры
     */
    @RequestMapping(value = "/teacher/{teacherLastName}/remove", method = RequestMethod.GET)
    public String removeAd(@PathVariable("teacherLastName") String lastName) {
        if(teacherService.findByLastName(lastName)==null){
            return "Такого преподавателя не существует";
        }
        teacherService.deleteByLastName(lastName);
        if (teacherService.findByLastName(lastName) == null) {
            return "Преподаватель успешно удален";
        } else {
            return "Ошибка удаления";
        }
    }

}
