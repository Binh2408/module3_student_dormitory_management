package org.example.quan_ly_ky_tuc_xa.entity;

import java.time.LocalDate;

public class ViolationRecord {
    private int violationRecordId;
    private String violationStudentName;
    private String violationTypeName;
    private String levelOfViolationName;
    private LocalDate timeOfViolation;

    public ViolationRecord() {
    }

    public ViolationRecord(int violationRecordId, String violationStudentName, String violationTypeName,
                           String levelOfViolationName, LocalDate timeOfViolation) {
        this.violationRecordId = violationRecordId;
        this.violationStudentName = violationStudentName;
        this.violationTypeName = violationTypeName;
        this.levelOfViolationName = levelOfViolationName;
        this.timeOfViolation = timeOfViolation;
    }

    public int getViolationRecordId() {
        return violationRecordId;
    }

    public void setViolationRecordId(int violationRecordId) {
        this.violationRecordId = violationRecordId;
    }

    public String getViolationStudentName() {
        return violationStudentName;
    }

    public void setViolationStudentName(String violationStudentName) {
        this.violationStudentName = violationStudentName;
    }

    public String getViolationTypeName() {
        return violationTypeName;
    }

    public void setViolationTypeName(String violationTypeName) {
        this.violationTypeName = violationTypeName;
    }

    public String getLevelOfViolationName() {
        return levelOfViolationName;
    }

    public void setLevelOfViolationName(String levelOfViolationName) {
        this.levelOfViolationName = levelOfViolationName;
    }

    public LocalDate getTimeOfViolation() {
        return timeOfViolation;
    }

    public void setTimeOfViolation(LocalDate timeOfViolation) {
        this.timeOfViolation = timeOfViolation;
    }
}
