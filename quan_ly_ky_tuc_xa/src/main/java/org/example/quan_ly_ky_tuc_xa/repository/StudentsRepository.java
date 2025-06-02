package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepository implements IStudentsRepository{
    public static List<Students> students = new ArrayList<>();
    static {
        students.add(new Students(1, "Nguyen Van A", 1001, 1, 123456789, 912345678, 10101));
        students.add(new Students(2, "Tran Thi B", 1002, 0, 234567890, 987654321, 10102));
        students.add(new Students(3, "Le Van C", 1003, 1, 345678901, 923456789, 10103));
    }
    @Override
    public List<Students> getAll() {
        return  students;
    }
}
