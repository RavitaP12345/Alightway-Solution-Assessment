package com.example.Alightway_Solutions.leave.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "leave_details")
public class LeaveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long leaveId;
    private String leaveType;
    @Temporal(TemporalType.DATE)
    private Date formDate;
    @Temporal(TemporalType.DATE)
    private Date toDate;
    private String employeeId;
    private String approvalId;
    private String ApprovalStatus;
    private String leaveStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ApprovalDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveSubmissionDate;
    private String createdBy;
    private String lastUpdatedBy;
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

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

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
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

    public Date getApprovalDate() {
        return ApprovalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        ApprovalDate = approvalDate;
    }

    public Date getLeaveSubmissionDate() {
        return leaveSubmissionDate;
    }

    public void setLeaveSubmissionDate(Date leaveSubmissionDate) {
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

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public String toString() {
        return "LeaveEntity{" +
                "leaveId=" + leaveId +
                ", leaveType='" + leaveType + '\'' +
                ", formDate=" + formDate +
                ", toDate=" + toDate +
                ", employeeId='" + employeeId + '\'' +
                ", approvalId='" + approvalId + '\'' +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", leaveStatus='" + leaveStatus + '\'' +
                ", ApprovalDate=" + ApprovalDate +
                ", leaveSubmissionDate=" + leaveSubmissionDate +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
