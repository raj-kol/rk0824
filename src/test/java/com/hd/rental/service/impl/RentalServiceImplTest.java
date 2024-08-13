package com.hd.rental.service.impl;

import com.hd.rental.model.RentalAgreement;
import com.hd.rental.model.RentalRequest;
import com.hd.rental.service.RentalService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RentalServiceImplTest {

    private final RentalService service = new RentalServiceImpl();

    @Test
    void test1() {
        RentalRequest request = new RentalRequest("JAKR", 5, 101, "9/3/15");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.getRentalAgreement(request));
        assertEquals("Discount percent is not in the range of 0 to 100", exception.getMessage());
    }

    @Test
    void test2() {
        RentalRequest request = new RentalRequest("LADW", 3, 10, "7/2/20");
        RentalAgreement actual = service.getRentalAgreement(request);
        assertEquals(10, actual.getDiscountPercent());
        assertEquals(LocalDate.parse("2020-07-05"), actual.getDueDate());
        assertEquals(2, actual.getChargeDays());
        assertEquals(BigDecimal.valueOf(3.98), actual.getPreDiscountCharge());
        assertEquals(BigDecimal.valueOf(0.40).setScale(2), actual.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.58), actual.getFinalCharge());
        String expected = "Tool Code: LADW\nTool Type: Ladder\nTool Brand: Werner\nNumber Of Days For Rental: 3\nCheck Out Date: 7/2/20\nDue Date: 7/5/20\nDaily Rental Charge: $1.99\nBillable Days: 2\nTotal before discount: $3.98\nDiscount Percentage: 10%\nDiscount Amount: $0.40\nTotal Due: $3.58";
        assertEquals(expected, actual.toString());
    }

    @Test
    void test3() {
        RentalRequest request = new RentalRequest("CHNS", 5, 25, "7/2/15");
        RentalAgreement actual = service.getRentalAgreement(request);
        assertEquals(25, actual.getDiscountPercent());
        assertEquals(LocalDate.parse("2015-07-07"), actual.getDueDate());
        assertEquals(3, actual.getChargeDays());
        assertEquals(BigDecimal.valueOf(4.47), actual.getPreDiscountCharge());
        assertEquals(BigDecimal.valueOf(1.12).setScale(2), actual.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.35), actual.getFinalCharge());
        String expected = "Tool Code: CHNS\nTool Type: Chainsaw\nTool Brand: Stihl\nNumber Of Days For Rental: 5\nCheck Out Date: 7/2/15\nDue Date: 7/7/15\nDaily Rental Charge: $1.49\nBillable Days: 3\nTotal before discount: $4.47\nDiscount Percentage: 25%\nDiscount Amount: $1.12\nTotal Due: $3.35";
        assertEquals(expected, actual.toString());

    }

    @Test
    void test4() {
        RentalRequest request = new RentalRequest("JAKD", 6, 0, "9/3/15");
        RentalAgreement actual = service.getRentalAgreement(request);
        assertEquals(0, actual.getDiscountPercent());
        assertEquals(LocalDate.parse("2015-09-09"), actual.getDueDate());
        assertEquals(3, actual.getChargeDays());
        assertEquals(BigDecimal.valueOf(8.97), actual.getPreDiscountCharge());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2), actual.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(8.97), actual.getFinalCharge());
        String expected = "Tool Code: JAKD\nTool Type: Jackhammer\nTool Brand: DeWalt\nNumber Of Days For Rental: 6\nCheck Out Date: 9/3/15\nDue Date: 9/9/15\nDaily Rental Charge: $2.99\nBillable Days: 3\nTotal before discount: $8.97\nDiscount Percentage: 0%\nDiscount Amount: $0.00\nTotal Due: $8.97";
        assertEquals(expected, actual.toString());
    }

    @Test
    void test5() {
        RentalRequest request = new RentalRequest("JAKR", 9, 0, "7/2/15");
        RentalAgreement actual = service.getRentalAgreement(request);
        assertEquals(0, actual.getDiscountPercent());
        assertEquals(LocalDate.parse("2015-07-11"), actual.getDueDate());
        assertEquals(5, actual.getChargeDays());
        assertEquals(BigDecimal.valueOf(14.95), actual.getPreDiscountCharge());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2), actual.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(14.95), actual.getFinalCharge());
        String expected = "Tool Code: JAKR\nTool Type: Jackhammer\nTool Brand: Ridgid\nNumber Of Days For Rental: 9\nCheck Out Date: 7/2/15\nDue Date: 7/11/15\nDaily Rental Charge: $2.99\nBillable Days: 5\nTotal before discount: $14.95\nDiscount Percentage: 0%\nDiscount Amount: $0.00\nTotal Due: $14.95";
        assertEquals(expected, actual.toString());
    }

    @Test
    void test6() {
        RentalRequest request = new RentalRequest("JAKR", 4, 50, "7/2/20");
        RentalAgreement actual = service.getRentalAgreement(request);
        assertEquals(50, actual.getDiscountPercent());
        assertEquals(LocalDate.parse("2020-07-06"), actual.getDueDate());
        assertEquals(1, actual.getChargeDays());
        assertEquals(BigDecimal.valueOf(2.99), actual.getPreDiscountCharge());
        assertEquals(BigDecimal.valueOf(1.50).setScale(2), actual.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(1.49), actual.getFinalCharge());
        String expected = "Tool Code: JAKR\nTool Type: Jackhammer\nTool Brand: Ridgid\nNumber Of Days For Rental: 4\nCheck Out Date: 7/2/20\nDue Date: 7/6/20\nDaily Rental Charge: $2.99\nBillable Days: 1\nTotal before discount: $2.99\nDiscount Percentage: 50%\nDiscount Amount: $1.50\nTotal Due: $1.49";
        assertEquals(expected, actual.toString());
    }

    @Test
    void test_invalid_tool_code() {
        RentalRequest request = new RentalRequest("TEST", 4, 50, "7/2/20");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> service.getRentalAgreement(request));
        assertEquals("Invalid tool code", exception.getMessage());
    }
}
