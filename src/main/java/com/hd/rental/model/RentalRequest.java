package com.hd.rental.model;

import com.google.common.base.Preconditions;
import com.hd.rental.util.DateUtils;

public class RentalRequest {

    private String toolCode;
    private int rentalDays;
    private int discountPercent;
    private String checkoutDate;

    public RentalRequest(String toolCode, int rentalDays, int discountPercent, String checkoutDate) {
        this.toolCode = toolCode;
        this.rentalDays = rentalDays;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void validate() {
        Preconditions.checkArgument(rentalDays > 1, "Rental day count is not 1 or greater");
        Preconditions.checkArgument(discountPercent >= 0 && discountPercent <= 100, "Discount percent is not in the range of 0 to 100");
        Preconditions.checkArgument(checkoutDate != null, "Checkout Date is required ");
        Preconditions.checkArgument(DateUtils.isValidDate(checkoutDate), "Checkout date should be in format MM/dd/yy ");
        Preconditions.checkArgument(toolCode != null, "tool code is required");
    }
}
