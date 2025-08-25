package com.mindex.challenge.data;

public class Compensation {
    private int salary;
    private String effectiveDate;
    private Employee employee;

    public Compensation() {
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
