package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.dao.CompensationRepository;

@Service
/* Implementation of the compensation service, capable of creating a new compensation object and inserting it into the
 * repository, as well as retrieving previously stored compensation objects based on ID
 */
public class CompensationServiceImpl implements CompensationService {
    
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    /* The repository that stores all of the compensation objects */
    private CompensationRepository compensationRepository;

    @Override
    /* Creates a new compensation object and stores it in the repository, called by the compensation controller */
    public Compensation create(Compensation compensation, String employeeId) {
        LOG.debug("Creating compensation for employee with id [{}]", employeeId);

        compensation.setEmployeeId(employeeId); 
        compensationRepository.insert(compensation);
        
        return compensation;
    }

    @Override
    /* Retrieves a pre-existing compensation object returns it, called by the compensation controller */
    public Compensation read(String employeeId) {
        LOG.debug("Getting compensation for employee with id [{}]", employeeId);

        Compensation compensation = compensationRepository.findByEmployeeId(employeeId);

        if (compensation == null) {
            throw new RuntimeException("Invalid employee id: [{}]" + employeeId);
        }

        return compensation;
    }
}
