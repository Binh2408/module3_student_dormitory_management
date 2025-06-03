package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.ViolationRecord;
import org.example.quan_ly_ky_tuc_xa.repository.IViolationRecordRepository;
import org.example.quan_ly_ky_tuc_xa.repository.ViolationRecordRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViolationRecordService implements IViolationRecordService {
    private static final IViolationRecordRepository violationRecordRepository = new ViolationRecordRepository();

    @Override
    public List<ViolationRecord> getAll() {
        return violationRecordRepository.getAll();
    }

    @Override
    public Map<String, String> add(ViolationRecord violationRecord) {
        Map<String, String> error = new HashMap<>();
        if (!violationRecord.getViolationStudentCode().matches("^SV-\\d{3}$")) {
            error.put("violationStudentCode", "Tên phải đúng định dạng.Vd: SV-000");
        }
        if (!violationRecord.getViolationTypeName().matches("^([\\p{Lu}][\\p{L}]*)(\\s[\\p{Lu}][\\p{L}]*)+$")) {
            error.put("violationTypeName", "In hoa ký tự đầu tiên");
        }
        if (error.isEmpty()) {
            violationRecordRepository.add(violationRecord);
        }
        return error;
    }
}



