package com.university.university.util;

import com.university.university.model.SemesterCycle;

import java.util.Calendar;

public class ValueFinder {

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


    /**
     * Находит оставшееся количество всех недель
     *
     * @return количество недель
     */
    public static int remainingWeek() {
        return SemesterCycle.getFinalDate().get(Calendar.WEEK_OF_YEAR) -
                SemesterCycle.getNowDate().get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Возвращает четность недели
     *
     * @param calendar принемает календарь
     * @return возвращает boolean четности недели true - even false - odd
     */
    public static boolean weekParity(Calendar calendar) {
        if (calendar.get(Calendar.WEEK_OF_YEAR) % 2 == 0) {
            return SemesterCycle.EVEN;
        } else {
            return SemesterCycle.ODD;
        }
    }
}
