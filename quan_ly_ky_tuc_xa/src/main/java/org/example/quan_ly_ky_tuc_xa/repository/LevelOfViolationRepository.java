package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.LevelOfViolation;

import java.util.ArrayList;
import java.util.List;

public class LevelOfViolationRepository implements ILevelOfViolationRepository{
    private static final List<LevelOfViolation> levelOfViolations = new ArrayList<>();
    static {
        LevelOfViolation level1 = new LevelOfViolation();
        level1.setLevelOfViolationCode(1);
        level1.setLevelOfViolationName("Nhẹ");

        LevelOfViolation level2 = new LevelOfViolation();
        level2.setLevelOfViolationCode(2);
        level2.setLevelOfViolationName("Trung bình");

        LevelOfViolation level3 = new LevelOfViolation();
        level3.setLevelOfViolationCode(3);
        level3.setLevelOfViolationName("Nghiêm trọng");

        levelOfViolations.add(level1);
        levelOfViolations.add(level2);
        levelOfViolations.add(level3);
    }
    @Override
    public List<LevelOfViolation> getAll() {
        return levelOfViolations;
    }
}
