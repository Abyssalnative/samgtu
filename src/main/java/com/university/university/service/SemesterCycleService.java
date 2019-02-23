package com.university.university.service;

import com.university.university.model.SemesterCycle;

import java.util.Calendar;

public class SemesterCycleService {


    /**
     * Находит количество оставшихся четных недель
     *
     * @return число четных недель
     */
    public static int remainingEvenWeek() {
        if (!(remainingWeek() % 2 == 0)) {
            if (weekParity(SemesterCycle.getNowDate()) == SemesterCycle.EVEN) {
                return remainingWeek() / 2 + 1;
            } else {
                return remainingWeek() / 2;
            }
        } else {
            return remainingWeek() / 2;
        }
    }

    /**
     * Находит количество оставшихся нечетных недель
     *
     * @return число нечетных недель
     */
    public static int remainingOddWeek() {
        if (!(remainingWeek() % 2 == 0)) {
            if (weekParity(SemesterCycle.getNowDate()) == SemesterCycle.EVEN) {
                return remainingWeek() / 2;
            } else {
                return remainingWeek() / 2 + 1;
            }
        } else {
            return remainingWeek() / 2;
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
