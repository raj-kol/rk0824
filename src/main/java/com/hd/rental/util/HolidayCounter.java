package com.hd.rental.util;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class HolidayCounter {

    private HolidayCounter() {
    }

    public static long countHolidaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return IntStream.rangeClosed(startDate.getYear(), endDate.getYear())
                .mapToObj(HolidayProvider::getHolidaysForYear)
                .flatMap(java.util.List::stream)
                .filter(holiday -> !holiday.isBefore(startDate) && !holiday.isAfter(endDate))
                .count();
    }

}
