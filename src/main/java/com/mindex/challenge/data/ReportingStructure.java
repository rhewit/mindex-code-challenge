package com.mindex.challenge.data;

import java.util.List;

import com.mindex.challenge.dao.EmployeeRepository;

/* This class represents a ReportingStructure, which consists of the employee who it pertains to, and the number of people who report to
 * the employee
 */
public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    /* Constructor, sets the employee */
    public ReportingStructure(Employee employee) {
        this.employee = employee;
    }

    /* Gets employee object corresponding to this reporting structure */
    public Employee getEmployee() {
        return employee;
    }

    /* Sets a new employee */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /* Gets the number of reporting employees as an int */
    public int getNumberOfReports() {
        return numberOfReports;
    }

    /* Sets the number of reporting employees using a helper function */
    public void setNumberOfReports(Employee employee, EmployeeRepository employeeRepository) {
        this.numberOfReports = reportCounter(employee, employeeRepository);
    }

    /* Counts the number of direct reports, then counts the number of reporting employees they have recursively */
    public int reportCounter(Employee employee, EmployeeRepository employeeRepository) {
        List<Employee> directReports = employee.getDirectReports();
        int numNonDirect = 0; int numDirect = 0;
        if (directReports != null) {
            numDirect = directReports.size();
            for (int i = 0; i < numDirect; i++) {
                String temp = directReports.get(i).getEmployeeId();
                Employee reportingEmployee = employeeRepository.findByEmployeeId(temp);
                numNonDirect += reportCounter(reportingEmployee, employeeRepository);
            }
        }
        return numDirect + numNonDirect;
    }
}





