package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.Contracts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractsRepository implements IContractsRepository{
    private static final List<Contracts> contractsList = new ArrayList<>();
    static {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        contractsList.add(new Contracts(
                1,
                "Nguyen Van A",
                "A101",
                LocalDate.parse("01/01/2024", formatter),
                LocalDate.parse("30/06/2024", formatter)
        ));

        contractsList.add(new Contracts(
                2,
                "Tran Thi B",
                "B202",
                LocalDate.parse("15/02/2024", formatter),
                LocalDate.parse("15/08/2024", formatter)
        ));

        contractsList.add(new Contracts(
                3,
                "Le Van C",
                "C303",
                LocalDate.parse("01/03/2024", formatter),
                LocalDate.parse("30/09/2024", formatter)
        ));
    }
    @Override
    public List<Contracts> getAll() {
        return contractsList;
    }

}
