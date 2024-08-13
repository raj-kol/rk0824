package com.hd.rental.util;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public final class DateUtils {
    private DateUtils() {
    }

    public static boolean isValidDate(String dateStr) {
        try {
            getLocalDate(dateStr);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDate getLocalDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
        return LocalDate.parse(dateStr, formatter);
    }


    public static long countWeekendDays(LocalDate startDate, LocalDate endDate) {
        // To exclude the start date
        startDate = startDate.plusDays(1);

        // To include the end date
        long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        // Calculate the number of full weeks
        long fullWeeks = totalDays / 7;

        // Calculate weekend days from full weeks
        long weekendDays = fullWeeks * 2;

        // Calculate the remaining days
        long remainingDays = totalDays % 7;

        // Find the starting day of the week
        DayOfWeek startDayOfWeek = startDate.getDayOfWeek();

        // Calculate the number of weekend days in the remaining period
        weekendDays += Stream.iterate(startDayOfWeek, day -> day.plus(1))
                .limit(remainingDays)
                .filter(day -> day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)
                .count();

        return weekendDays;
    }

    public static String getFormattedDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
        return date.format(formatter);
    }

}
