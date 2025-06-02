package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.ViolationRecord;
import org.example.quan_ly_ky_tuc_xa.repository.IViolationRecordRepository;
import org.example.quan_ly_ky_tuc_xa.repository.ViolationRecordRepository;

import java.util.List;

public class ViolationRecordService implements IViolationRecordService{
    private static final IViolationRecordRepository violationRecordRepository=new ViolationRecordRepository();
    @Override
    public List<ViolationRecord> getAll() {
        return violationRecordRepository.getAll();
    }
}
