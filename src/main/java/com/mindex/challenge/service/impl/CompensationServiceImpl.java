package com.mindex.challenge.service.impl;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.dao.CompensationRepository;

@Service
public class CompensationServiceImpl implements CompensationService {
    
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Compensation create(Compensation compensation, String employeeId) {
        LOG.debug("Creating compensation for employee with id [{}]", employeeId);

        compensation.setSalary((int) (Math.random()) * 100000);
        compensation.setEffectiveDate(LocalDate.now().toString());
        compensation.setEmployeeId(employeeId); 
        compensationRepository.insert(compensation);
        
        return compensation;
    }

    @Override
    public Compensation read(String employeeId) {
        LOG.debug("Getting compensation for employee with id [{}]", employeeId);

        Compensation compensation = compensationRepository.findByEmployeeId(employeeId);

        if (compensation == null) {
            throw new RuntimeException("Invalid employee id: [{}]" + employeeId);
        }

        return compensation;
    }
}
