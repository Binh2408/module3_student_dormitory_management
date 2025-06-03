package org.example.quan_ly_ky_tuc_xa.service;

import org.example.quan_ly_ky_tuc_xa.entity.Contracts;
import org.example.quan_ly_ky_tuc_xa.repository.ContractsRepository;
import org.example.quan_ly_ky_tuc_xa.repository.IContractsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractsService implements IContractsService {
    private static final IContractsRepository contractsRepository=new ContractsRepository();

    @Override
    public List<Contracts> getAll() {
        return contractsRepository.getAll();
    }

    @Override
    public Map<String, String> add(Contracts contract) {
        Map<String,String> error=new HashMap<>();
        if (!contract.getContractCode().matches("^HD-\\d{3}$")){
            error.put("contractCode","Tên phải đúng định dạng. Vd: HD-002");
        }
        if (!contract.getStudentCode().matches("^SV-\\d{3}$")){
            error.put("studentCode","Tên phải đúng định dạng. Vd: SV-002");
        }
        if(!contract.getRoomName().matches("^RO-\\d{3}")){
            error.put("room","Tên phải đúng định dạng. Vd: RO-003");
        }
        if (contract.getRentalCost()<=0){
            error.put("rentalCost","chi phí thuê phải lớn hơn 0");
        }
        if(error.isEmpty()){
            contractsRepository.add(contract);
        }
        return error;
    }

}
