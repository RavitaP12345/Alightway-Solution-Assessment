package com.example.Alightway_Solutions.leave.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LeaveModel {
    private Long leaveId;
    @NotNull(message = "Leave Type must not be null.")
    @NotBlank(message = "Leave Type must not be blank.")
    @NotEmpty(message = "Leave Type must not be empty.")
    private String leaveType;
    @NotNull(message = "From date must not be null.")
    @NotBlank(message = "From date must not be blank.")
    @NotEmpty(message = "From date must not be empty.")
    private String formDate;
    @NotNull(message = "To date must not be null.")
    @NotBlank(message = "To date must not be blank.")
    @NotEmpty(message = "To date must not be empty.")
    private String toDate;
    @NotNull(message = "Employee ID must not be null.")
    @NotBlank(message = "Employee ID must not be blank.")
    @NotEmpty(message = "Employee ID must not be empty.")
    private String employeeId;
    @NotNull(message = "Approval ID must not be null.")
    @NotBlank(message = "Approval ID must not be blank.")
    @NotEmpty(message = "Approval ID must not be empty.")
    private String approvalId;
    private String ApprovalStatus;
    private String leaveStatus;
    private String ApprovalDate;
    private String leaveSubmissionDate;
    private String createdBy;
    private String lastUpdatedBy;
    private String status;

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalStatus() {
        return ApprovalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        ApprovalStatus = approvalStatus;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getApprovalDate() {
        return ApprovalDate;
    }

    public void setApprovalDate(String approvalDate) {
        ApprovalDate = approvalDate;
    }

    public String getLeaveSubmissionDate() {
        return leaveSubmissionDate;
    }

    public void setLeaveSubmissionDate(String leaveSubmissionDate) {
        this.leaveSubmissionDate = leaveSubmissionDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LeaveModel{" +
                "leaveId=" + leaveId +
                ", leaveType='" + leaveType + '\'' +
                ", formDate='" + formDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", approvalId='" + approvalId + '\'' +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", leaveStatus='" + leaveStatus + '\'' +
                ", ApprovalDate='" + ApprovalDate + '\'' +
                ", leaveSubmissionDate='" + leaveSubmissionDate + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
