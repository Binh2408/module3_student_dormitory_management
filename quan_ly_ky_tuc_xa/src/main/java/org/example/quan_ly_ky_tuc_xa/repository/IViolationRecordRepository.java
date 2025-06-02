package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.ViolationRecord;

import java.util.List;

public interface IViolationRecordRepository {
    List<ViolationRecord> getAll();
}
