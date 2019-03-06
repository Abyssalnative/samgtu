package com.university.university.controller;

import com.university.university.entity.Lesson;
import com.university.university.entity.Schedule;
import com.university.university.entity.Teacher;
import com.university.university.service.LessonService;
import com.university.university.service.ScheduleService;
import com.university.university.service.TeacherService;
import com.university.university.util.SemesterCycleUtil;
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

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String addTeacher(@RequestParam String firstName, @RequestParam String lastName) {
        if (teacherService.findByLastName(lastName) != null) {
            return "Такой преподаватель уже существует";
        }
        teacherService.addTeacher(firstName, lastName);
        if (teacherService.findByLastName(lastName) != null) {
            return "Преподаватель успешно добавлен";
        } else {
            return "Ошибка добавления";
        }
    }

    @RequestMapping(value = "/lesson", method = RequestMethod.POST)
    public String addLesson(@RequestParam(value = "teacherId") long teacherId, @RequestParam String lessonName, @RequestParam String type) {
        if (lessonService.findByNameAndType(lessonName, type) != null) {
            return "Такой предмет уже существует";
        }
        lessonService.addLesson(teacherId, lessonName, type);
        if (lessonService.findByNameAndType(lessonName, type) != null) {
            return "Предмет успешно добавлен";
        } else {
            return "Ошибка добавления";
        }
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public String addSchedule(@RequestParam(name = "lessonId") long lessonId, @RequestParam(name = "even") boolean even,
                              @RequestParam(name = "day") int day, @RequestParam(name = "pairOrder") int pairOrder) {
        if (scheduleService.findCopy(even, day, pairOrder) != null) {
            return "Такая позиция уже существует";
        }
        scheduleService.saveSchedule(lessonId, even, day, pairOrder);
        if (scheduleService.findSchedule(lessonId, even, pairOrder, day) != null) {
            return "Успешно добавлено";
        } else {
            return "Ошибка добавления";
        }
    }

    /**
     * Находит следущий предмет
     *
     * @param id предмета
     * @return предмет
     */
    @RequestMapping(value = "/schedule/next", method = RequestMethod.GET)
    public Schedule findNextLesson(@RequestParam(name = "lessonId") long id) {
        return scheduleService.findNextLesson(id);
    }

    /**
     * Возвращает список предметов по ID преподавателя
     *
     * @param id преподавателя
     * @return список предметов
     */
    @RequestMapping(value = "/lesson", method = RequestMethod.GET)
    public List<Lesson> getLessonListByTeacherId(@RequestParam(name = "teacherId") long id) {
        return lessonService.findByTeacherId(id);
    }

    /**
     * Находит предмет
     *
     * @param id преподавателя
     * @return предмет
     */
    @RequestMapping(value = "/lesson/current", method = RequestMethod.GET)
    public Lesson getLessonNameByTeacherId(@RequestParam(name = "teacherId") long id) {
        return lessonService.findFirstByTeacherId(id);
    }

    /**
     * Служит для заполнения расписания
     *
     * @param current переменная для указания какую именно неделю нужно вернуть
     * @return позиции на неделю
     */
    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public List<Schedule> getScheduleEven(@RequestParam(name = "current") boolean current) {
        if (current) {
            return scheduleService.findByEven(SemesterCycleUtil.findCurrentEvenWeek());
        } else {
            return scheduleService.findByEven(!(SemesterCycleUtil.findCurrentEvenWeek()));
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
     * Удаляет преподавателя
     *
     * @param id преподавателя
     * @return статус процедуры
     */
    @RequestMapping(value = "/teacher", method = RequestMethod.DELETE)
    public String removeTeacher(@RequestParam(name = "teacherId") long id) {
        if (teacherService.findById(id) == null) {
            return "Такого преподавателя не существует";
        }
        teacherService.deleteById(id);
        if (teacherService.findById(id) == null) {
            return "Преподаватель успешно удален";
        } else {
            return "Ошибка удаления";
        }
    }
}
