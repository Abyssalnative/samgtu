package com.university.university.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SemesterCycle extends GregorianCalendar {

    public static final boolean EVEN = true;
    public static final boolean ODD = false;
    private static Calendar finalDate = new GregorianCalendar(2019, Calendar.MAY, 31);
    private static Calendar nowDate = new GregorianCalendar();

    public static Calendar getFinalDate() {
        return finalDate;
    }

    public static Calendar getNowDate() {
        return nowDate;
    }
}
