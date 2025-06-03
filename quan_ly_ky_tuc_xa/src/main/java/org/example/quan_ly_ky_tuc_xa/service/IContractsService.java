package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.Contracts;

import java.util.List;
import java.util.Map;

public interface IContractsService {
    List<Contracts> getAll();
    Map<String,String> add(Contracts contract);
}
