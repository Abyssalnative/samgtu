package com.university.university.model;

import java.util.Calendar;

public class SemesterCycleService {

    /*
    Возвращает количество оставшихся четных недель
     */
    public static int remainingEvenWeek() {
        if (!(remainingWeek() % 2 == 0)) {
            if (weekParity(SemesterCycle.getNowDate()).equals(SemesterCycle.EVEN)) {
                return remainingWeek() / 2 + 1;
            } else {
                return remainingWeek() / 2;
            }
        } else {
            return remainingWeek() / 2;
        }
    }

    /*
    Возвращает количество оставшихся нечетных недель
     */
    public static int remainingOddWeek() {
        if (!(remainingWeek() % 2 == 0)) {
            if (SemesterCycle.getNowDate().equals(SemesterCycle.EVEN)) {
                return remainingWeek() / 2;
            } else {
                return remainingWeek() / 2 + 1;
            }
        } else {
            return remainingWeek() / 2;
        }
    }

    /*
    Высчитывает и возвращает оставшееся количество учебных недель
     */
    public static int remainingWeek() {
        return SemesterCycle.getFinalDate().get(Calendar.WEEK_OF_YEAR) -
                SemesterCycle.getNowDate().get(Calendar.WEEK_OF_YEAR);
    }

    /*
    Возвращает четность недели
     */
    public static String weekParity(Calendar calendar) {
        if (calendar.get(Calendar.WEEK_OF_YEAR) % 2 == 0) {
            return SemesterCycle.EVEN;
        } else {
            return SemesterCycle.ODD;
        }
    }


}
