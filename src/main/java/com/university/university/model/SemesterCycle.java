package com.university.university.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SemesterCycle extends GregorianCalendar {

    static final String EVEN = "Четная";
    static final String ODD = "Нечетная";
    private static Calendar finalDate = new GregorianCalendar(2019, Calendar.MAY, 31);
    private static Calendar nowDate = new GregorianCalendar();

    public static Calendar getFinalDate() {
        return finalDate;
    }

    public static Calendar getNowDate() {
        return nowDate;
    }
}
