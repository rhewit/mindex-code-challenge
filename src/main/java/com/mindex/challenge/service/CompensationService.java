package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

/* Interface for compensation service */
public interface CompensationService {
    Compensation create(Compensation compensation, String employeeId);
    Compensation read(String employeeId);
}
