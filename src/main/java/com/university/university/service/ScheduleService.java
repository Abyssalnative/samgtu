package com.university.university.service;


import com.university.university.entity.Schedule;

import java.util.List;

public interface ScheduleService {


    /**
     * Находит расписание на текущую неделю
     *
     * @return расписание предметов CurrentWeek
     */
    List<Schedule> findByEven(boolean even);

    /**
     * Првоеряет есть ли на этой недели предмет который еще не прошел, если нет то проверяет
     * есть ли на следующей неделе предмет если нет то берет предмет с этой недели(при этом предмет будет
     * по счету в неделе меньше чем nowDate, что значит что он будет только через неделю)
     *
     * @param name фамилия преподавателя
     *
     * @return позиция расписания
     */
    Schedule findNearestLesson(String name);

    /**
     * Добавляет новую позицию в расписании
     *
     * @param even четность недели
     * @param lastName фамилия преподавателя
     * @param type тип предмета
     * @param day день предмета
     * @param pairOrder какой по счету предмет
     */
    void addSchedule(boolean even,String lastName, String type, int day,int pairOrder);

    /**
     * Находит позицию в расписании
     *
     * @param even четность недели
     * @param day день недели
     * @param pairOrder какой по счету предмет
     * @param lastName фамилию преподавателя
     * @return позицию расписания
     */
    Schedule findByEvenAndDayAndPairOrderAndLessonTeacherLastName(boolean even, int day, int pairOrder, String lastName);



}
