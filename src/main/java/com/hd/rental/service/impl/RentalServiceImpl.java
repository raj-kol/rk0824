package com.hd.rental.service.impl;

import com.hd.rental.data.ToolRepository;
import com.hd.rental.model.PriceInfo;
import com.hd.rental.model.RentalAgreement;
import com.hd.rental.model.RentalRequest;
import com.hd.rental.model.Tool;
import com.hd.rental.service.RentalService;
import com.hd.rental.util.DateUtils;
import com.hd.rental.util.HolidayCounter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class RentalServiceImpl implements RentalService {

    private final ToolRepository toolRepository = new ToolRepository();

    public RentalAgreement getRentalAgreement(RentalRequest request) {
        request.validate();
        Optional<Tool> tool = toolRepository.finByCode(request.getToolCode());
        tool.orElseThrow(() -> new IllegalArgumentException("Invalid tool code"));
        RentalAgreement agreement = createRentalAgreement(request, tool.orElse(null));
        calculateCharges(agreement);
        agreement.printReceipt();
        return agreement;
    }

    private void calculateCharges(RentalAgreement agreement) {
        agreement.setPreDiscountCharge(calculatePreDiscountCharge(agreement));
        agreement.setDiscountAmount(calculateDiscountAmount(agreement));
        agreement.setFinalCharge(calculateFinalCharge(agreement));
    }

    private RentalAgreement createRentalAgreement(RentalRequest request, Tool tool) {
        RentalAgreement agreement = new RentalAgreement();
        agreement.setToolCode(tool.getCode());
        agreement.setToolType(tool.getType());
        agreement.setToolBrand(tool.getBrand());
        agreement.setRentalDays(request.getRentalDays());
        agreement.setDailyRentalCharge(tool.getPriceInfo().getDailyCharge());
        agreement.setCheckoutDate(DateUtils.getLocalDate(request.getCheckoutDate()));
        agreement.setDueDate(agreement.getCheckoutDate().plusDays(request.getRentalDays()));
        agreement.setChargeDays(calculateChargeDays(agreement, tool.getPriceInfo()));
        agreement.setDiscountPercent(request.getDiscountPercent());
        return agreement;
    }

    private BigDecimal calculatePreDiscountCharge(RentalAgreement agreement) {
        return BigDecimal.valueOf(agreement.getDailyRentalCharge())
                .multiply(BigDecimal.valueOf(agreement.getChargeDays()))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateDiscountAmount(RentalAgreement agreement) {
        return agreement.getPreDiscountCharge()
                .multiply(BigDecimal.valueOf(agreement.getDiscountPercent()))
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    private BigDecimal calculateFinalCharge(RentalAgreement agreement) {
        return agreement.getPreDiscountCharge().subtract(agreement.getDiscountAmount());
    }

    private long calculateChargeDays(RentalAgreement agreement, PriceInfo priceInfo) {
        long chargeDays = agreement.getRentalDays();
        if (!priceInfo.isEligibleForWeekendCharge()) {
            chargeDays -= DateUtils.countWeekendDays(agreement.getCheckoutDate(), agreement.getDueDate());
        }
        if (!priceInfo.isEligibleForHolidayCharge()) {
            chargeDays -= HolidayCounter.countHolidaysBetweenDates(agreement.getCheckoutDate(), agreement.getDueDate());
        }
        return chargeDays;
    }
}