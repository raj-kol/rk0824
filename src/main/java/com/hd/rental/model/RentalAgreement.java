package com.hd.rental.model;

import com.hd.rental.util.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.hd.rental.util.NumberFormatUtils.formatCurrency;
import static com.hd.rental.util.NumberFormatUtils.formatPercentage;

public class RentalAgreement {

    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private float dailyRentalCharge;
    private long chargeDays;
    private BigDecimal preDiscountCharge;
    private int discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public float getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(float dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public long getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(long chargeDays) {
        this.chargeDays = chargeDays;
    }

    public BigDecimal getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(BigDecimal preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(BigDecimal finalCharge) {
        this.finalCharge = finalCharge;
    }

    public void printReceipt() {
        System.out.println("\n" + this + "\n");
    }

    @Override
    public String toString() {
        return "Tool Code: " + getToolCode() + "\n" +
                "Tool Type: " + getToolType() + "\n" +
                "Tool Brand: " + getToolBrand() + "\n" +
                "Number Of Days For Rental: " + getRentalDays() + "\n" +
                "Check Out Date: " + DateUtils.getFormattedDate(getCheckoutDate()) + "\n" +
                "Due Date: " + DateUtils.getFormattedDate(getDueDate()) + "\n" +
                "Daily Rental Charge: " + formatCurrency(getDailyRentalCharge()) + "\n" +
                "Billable Days: " + getChargeDays() + "\n" +
                "Total before discount: " + formatCurrency(getPreDiscountCharge()) + "\n" +
                "Discount Percentage: " + formatPercentage(getDiscountPercent()) + "\n" +
                "Discount Amount: " + formatCurrency(getDiscountAmount()) + "\n" +
                "Total Due: " + formatCurrency(getFinalCharge());
    }
}
