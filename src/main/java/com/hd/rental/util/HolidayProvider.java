package com.hd.rental.util;

import com.hd.rental.model.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class HolidayProvider {

    private static final List<Holiday> HOLIDAYS = List.of(
            new Holiday("Independence Day", Month.JULY, 4, HolidayProvider::getObservedIndependenceDay),
            new Holiday("Labor Day", Month.SEPTEMBER, 1, HolidayProvider::getLaborDay)
    );

    private static LocalDate getObservedIndependenceDay(int year) {
        LocalDate independenceDay = LocalDate.of(year, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY) {
            return independenceDay.minusDays(1);
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            return independenceDay.plusDays(1);
        }

        return independenceDay;
    }

    private static LocalDate getLaborDay(int year) {
        return LocalDate.of(year, Month.SEPTEMBER, 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
    }

    public static List<LocalDate> getHolidaysForYear(int year) {
        List<LocalDate> holidays = new ArrayList<>();
        for (Holiday holiday : HOLIDAYS) {
            holidays.add(holiday.getHolidayDate(year));
        }
        return holidays;
    }


}