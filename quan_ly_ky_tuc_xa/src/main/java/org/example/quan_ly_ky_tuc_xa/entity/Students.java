package org.example.quan_ly_ky_tuc_xa.entity;

public class Students {
    private int studentId;
    private String studentName;
    private int usernameCode;
    private int genderCode;
    private int numberCMND;
    private int numberPhone;
    private int email;

    public Students() {
    }

    public Students(int studentId, String studentName, int usernameCode, int genderCode, int numberCMND, int numberPhone, int email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.usernameCode = usernameCode;
        this.genderCode = genderCode;
        this.numberCMND = numberCMND;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getUsernameCode() {
        return usernameCode;
    }

    public void setUsernameCode(int usernameCode) {
        this.usernameCode = usernameCode;
    }

    public int getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(int genderCode) {
        this.genderCode = genderCode;
    }

    public int getNumberCMND() {
        return numberCMND;
    }

    public void setNumberCMND(int numberCMND) {
        this.numberCMND = numberCMND;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }
}
