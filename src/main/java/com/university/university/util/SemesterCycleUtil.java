package com.university.university.util;

import com.university.university.model.SemesterCycle;

public class SemesterCycleUtil {

    /**
     * Находит какая сейчас неделя
     *
     * @return возвращает true - четная, false - нечетная
     */
    public static boolean findCurrentEvenWeek() {
        if (SemesterCycle.getNowDate().getWeeksInWeekYear() % 2 == 0) {
            return SemesterCycle.ODD;
        } else {
            return SemesterCycle.EVEN;
        }
    }
}
