package com.mindex.challenge.data;

import java.util.List;

import com.mindex.challenge.dao.EmployeeRepository;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;


    public ReportingStructure(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(Employee employee, EmployeeRepository employeeRepository) {
        this.numberOfReports = reportCounter(employee, employeeRepository);
    }

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





