package com.hd.rental.model;


public class PriceInfo {

    private String type;
    private float dailyCharge;
    private boolean isEligibleForWeekdayCharge;
    private boolean isEligibleForWeekendCharge;
    private boolean isEligibleForHolidayCharge;

    public PriceInfo(String type, float dailyCharge, boolean isEligibleForWeekdayCharge, boolean isEligibleForWeekendCharge, boolean isEligibleForHolidayCharge) {
        this.type = type;
        this.dailyCharge = dailyCharge;
        this.isEligibleForWeekdayCharge = isEligibleForWeekdayCharge;
        this.isEligibleForWeekendCharge = isEligibleForWeekendCharge;
        this.isEligibleForHolidayCharge = isEligibleForHolidayCharge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(float dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public boolean isEligibleForWeekdayCharge() {
        return isEligibleForWeekdayCharge;
    }

    public void setEligibleForWeekdayCharge(boolean eligibleForWeekdayCharge) {
        isEligibleForWeekdayCharge = eligibleForWeekdayCharge;
    }

    public boolean isEligibleForWeekendCharge() {
        return isEligibleForWeekendCharge;
    }

    public void setEligibleForWeekendCharge(boolean eligibleForWeekendCharge) {
        isEligibleForWeekendCharge = eligibleForWeekendCharge;
    }

    public boolean isEligibleForHolidayCharge() {
        return isEligibleForHolidayCharge;
    }

    public void setEligibleForHolidayCharge(boolean eligibleForHolidayCharge) {
        isEligibleForHolidayCharge = eligibleForHolidayCharge;
    }
}
