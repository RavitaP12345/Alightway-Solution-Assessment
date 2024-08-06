package com.example.Alightway_Solutions.salary.models;

public class SalarySlip {
    private String employeeId;
    private Integer totalLeave;
    private Integer totalEventsOfCurrentMonth;
    private String startDate;
    private String endDate;
    private Double finalSalary;
    private Double workingDays;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTotalLeave() {
        return totalLeave;
    }

    public void setTotalLeave(Integer totalLeave) {
        this.totalLeave = totalLeave;
    }

    public Integer getTotalEventsOfCurrentMonth() {
        return totalEventsOfCurrentMonth;
    }

    public void setTotalEventsOfCurrentMonth(Integer totalEventsOfCurrentMonth) {
        this.totalEventsOfCurrentMonth = totalEventsOfCurrentMonth;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(Double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public Double getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Double workingDays) {
        this.workingDays = workingDays;
    }
}
