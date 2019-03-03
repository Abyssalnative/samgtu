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
     * @param id фамилия преподавателя
     *
     * @return позиция расписания
     */
    Schedule findNextLesson(long id);

    Schedule findSchedule(long id, boolean even, int pairOrder, int day);

    Schedule findCopy(boolean even, int day, int pairOrder);

    Schedule saveSchedule(long lessonId, boolean even, int day, int pairOrder);



}
