package com.example.Alightway_Solutions.event.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EventModel {
    private Long eventId;
    @NotNull(message = "Event name must not be null.")
    @NotBlank(message = "Event name must not be blank.")
    @NotEmpty(message = "Event name must not be empty.")
    private String eventName;
    @NotNull(message = "Event date must not be null.")
    @NotBlank(message = "Event date must not be blank.")
    @NotEmpty(message = "Event date must not be empty.")
    private String eventDate;
    private String creationDate;
    private String lastUpdatedDate;
    private String status;
    @NotNull(message = "Created By must not be null.")
    @NotBlank(message = "Created By must not be blank.")
    @NotEmpty(message = "Created By must not be empty.")
    private String createdBy;
    @NotNull(message = "Last Updated By must not be null.")
    @NotBlank(message = "Last Updated By must not be blank.")
    @NotEmpty(message = "Last Updated By must not be empty.")
    private String lastUpdatedBy;
    @NotNull(message = "Is official must not be null.")
    @NotBlank(message = "Is official must not be blank.")
    @NotEmpty(message = "Is official must not be empty.")
    private String isOfficial;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", lastUpdatedDate='" + lastUpdatedDate + '\'' +
                ", status='" + status + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                '}';
    }
}
