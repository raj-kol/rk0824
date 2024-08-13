package com.hd.rental.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatUtils {
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public static String formatCurrency(Number amount) {
        if (amount instanceof BigDecimal) {
            return currencyFormatter.format(amount);
        } else if (amount instanceof Float || amount instanceof Double) {
            return currencyFormatter.format(amount.doubleValue());
        } else {
            return currencyFormatter.format(amount.longValue());
        }
    }

    public static String formatPercentage(int percentageAmount) {
        return String.format("%d%%", percentageAmount);
    }
}
