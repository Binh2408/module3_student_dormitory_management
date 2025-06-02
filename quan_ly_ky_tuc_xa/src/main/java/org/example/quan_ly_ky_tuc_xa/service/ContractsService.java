package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.Contracts;
import org.example.quan_ly_ky_tuc_xa.repository.ContractsRepository;
import org.example.quan_ly_ky_tuc_xa.repository.IContractsRepository;

import java.util.List;

public class ContractsService implements IContractsService {
    private static final IContractsRepository contractsRepository=new ContractsRepository();

    @Override
    public List<Contracts> getAll() {
        return contractsRepository.getAll();
    }
}
