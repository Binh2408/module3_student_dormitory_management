package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.ViolationType;

import java.util.ArrayList;
import java.util.List;

public class ViolationTypeRepository implements IViolationTypeRepository{
    private static final List<ViolationType> violationTypes = new ArrayList<>();
    static {
        violationTypes.add(new ViolationType(1, "Làm ồn", 50000));
        violationTypes.add(new ViolationType(2, "Xả rác", 100000));
        violationTypes.add(new ViolationType(3, "Hút thuốc trong phòng", 150000));
    }
    @Override
    public List<ViolationType> getAll() {
        return violationTypes;
    }
}
