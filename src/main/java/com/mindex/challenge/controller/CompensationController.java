package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* This class is the controller for creating and reading compensation objects 
 * Syntax for POST: curl -H 'Content-Type: application/json' \
      -d "{""salary"":{salary int},""effectiveDate"":"{effectiveDate String}"}" \
      -X POST http://localhost:8080/compensation/{id}

   Syntax for GET: curl http://localhost:8080/compensationget/{id}
*/
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @PostMapping("/compensation/{id}")
    /* This function creates a compensation object based on an id path variable from the URL */
    public Compensation create(@PathVariable String id, @RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for employee id [{}]", id);

        return compensationService.create(compensation, id);
    }

    @GetMapping("/compensationget/{id}")
    /* This function gets a pre-existing compensation object based on an id path variable from the URL */
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation get request for employee id [{}]", id);

        return compensationService.read(id);
    }
}
