package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.ViolationRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ViolationRecordRepository implements IViolationRecordRepository{
    private static final List<ViolationRecord> violationRecords = new ArrayList<>();

    static {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        violationRecords.add(new ViolationRecord(1, "Nguyen Van A",
                "Xả rác", "Trung bình", LocalDate.parse("10/05/2024", formatter)));
        violationRecords.add(new ViolationRecord(2, "Tran Thi B",
                "Hút thuốc trong phòng", "Nghiêm trọng", LocalDate.parse("15/05/2024", formatter)));
        violationRecords.add(new ViolationRecord(3, "Le Van C",
                "Làm ồn", "Nhẹ", LocalDate.parse("20/05/2024", formatter)));
    }
    @Override
    public List<ViolationRecord> getAll() {
        return violationRecords;
    }
}
