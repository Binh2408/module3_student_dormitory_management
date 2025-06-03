package org.example.quan_ly_ky_tuc_xa.entity;

import java.time.LocalDate;

public class Contracts {
    private String contractCode;
    private String studentCode;
    private String roomName;;
    private LocalDate startDay;
    private LocalDate endDay;
    private double rentalCost;


    public Contracts() {
    }
    public Contracts(String studentName,String roomName, LocalDate startDay, LocalDate endDay, double rentalCost) {
        this.studentCode = studentName;
        this.roomName = roomName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.rentalCost=rentalCost;
    }

    public Contracts(String contractCode, String studentName,String roomName, LocalDate startDay, LocalDate endDay,double rentalCost) {
        this.contractCode = contractCode;
        this.studentCode = studentName;
        this.roomName = roomName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.rentalCost=rentalCost;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }


    public String getStudentName() {
        return studentCode;
    }

    public void setStudentName(String studentName) {
        this.studentCode = studentName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }
}
