package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;


    public ReportingStructure(Employee employee) {
        this.employee = employee;
        this.numberOfReports = reportCounter(employee);
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

    public void setNumberOfReports(Employee employee) {
        this.numberOfReports = reportCounter(employee);
    }

    public int reportCounter(Employee employee) {
        List<Employee> directReports = employee.getDirectReports();
        int numDirect = directReports.size();
        int numNonDirect = 0;
        for (int i = 0; i < numDirect; i++) {
            numNonDirect += reportCounter(directReports.get(i));
        }
        return numDirect + numNonDirect;
    }
}





