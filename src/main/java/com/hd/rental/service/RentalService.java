package com.hd.rental.service;

import com.hd.rental.model.RentalAgreement;
import com.hd.rental.model.RentalRequest;

public interface RentalService {
    RentalAgreement getRentalAgreement(RentalRequest request);
}
