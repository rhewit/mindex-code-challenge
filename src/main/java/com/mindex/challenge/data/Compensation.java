package com.mindex.challenge.data;

/* This is a compensation object, which consists of an employeeId used to identify which employee the compensation corresponds to, the
 * salary number, and the effective start date of said salary
*/
public class Compensation {
    private String employeeId;
    private int salary;
    private String effectiveDate;
    
    /* Contructor */
    public Compensation() {
    }

    /* Gets ID of corresponding employee */
    public String getEmployeeId() {
        return employeeId;
    }

    /* Sets ID linked to the compensation for initialization purposes */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /* Gets salary as an integer */
    public int getSalary() {
        return salary;
    }

    /* Sets the salary of the compensation object as an integer */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /* Gets the effective start date of the compensation object as a String */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /* Sets the effective start date of the compensation object as a String */
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
