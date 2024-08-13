package com.hd.rental.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

public class Holiday {

    private final String name;
    private final Month month;
    private final int day;
    private final Function<Integer, LocalDate> dateCalculator;

    public Holiday(String name, Month month, int day, Function<Integer, LocalDate> dateCalculator) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.dateCalculator = dateCalculator;
    }

    public LocalDate getHolidayDate(int year) {
        return dateCalculator.apply(year);
    }
}
