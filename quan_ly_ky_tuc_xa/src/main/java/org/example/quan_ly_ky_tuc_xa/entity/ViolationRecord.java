package org.example.quan_ly_ky_tuc_xa.entity;

import java.time.LocalDate;

public class ViolationRecord {
    private String violationRecordCode;
    private String violationStudentCode;
    private String violationTypeName;
    private String levelOfViolationName;
    private LocalDate timeOfViolation;

    public ViolationRecord() {
    }

    public ViolationRecord(String violationRecordCode, String violationStudentName, String violationTypeName,
                           String levelOfViolationName, LocalDate timeOfViolation) {
        this.violationRecordCode = violationRecordCode;
        this.violationStudentCode = violationStudentName;
        this.violationTypeName = violationTypeName;
        this.levelOfViolationName = levelOfViolationName;
        this.timeOfViolation = timeOfViolation;
    }

    public String getViolationRecordCode() {
        return violationRecordCode;
    }

    public void setViolationRecordCode(String violationRecordCode) {
        this.violationRecordCode = violationRecordCode;
    }

    public String getViolationStudentCode() {
        return violationStudentCode;
    }

    public void setViolationStudentCode(String violationStudentCode) {
        this.violationStudentCode = violationStudentCode;
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
