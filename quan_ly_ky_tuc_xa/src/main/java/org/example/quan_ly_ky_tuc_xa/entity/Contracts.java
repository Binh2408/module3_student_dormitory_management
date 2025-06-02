package org.example.quan_ly_ky_tuc_xa.entity;

import java.time.LocalDate;

public class Contracts {
    private int contractId;
    private String studentName;
    private String roomName;;
    private LocalDate startDay;
    private LocalDate endDay;

    public Contracts() {
    }

    public Contracts(int contractId, String studentName,String roomCode, LocalDate startDay, LocalDate endDay) {
        this.contractId = contractId;
        this.studentName = studentName;
        this.roomName = roomCode;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
