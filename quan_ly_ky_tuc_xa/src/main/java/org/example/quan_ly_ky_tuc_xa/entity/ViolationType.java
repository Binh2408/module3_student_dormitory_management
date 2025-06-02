package org.example.quan_ly_ky_tuc_xa.entity;

public class ViolationType {
    private  int violationCode;
    private  String violationName;
    private  double penalty;

    public ViolationType() {
    }

    public ViolationType(int violationCode, String violationName, double penalty) {
        this.violationCode = violationCode;
        this.violationName = violationName;
        this.penalty = penalty;
    }

    public int getViolationCode() {
        return violationCode;
    }

    public void setViolationCode(int violationCode) {
        this.violationCode = violationCode;
    }

    public String getViolationName() {
        return violationName;
    }

    public void setViolationName(String violationName) {
        this.violationName = violationName;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}
