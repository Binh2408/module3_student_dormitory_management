package org.example.quan_ly_ky_tuc_xa.repository;

import org.example.quan_ly_ky_tuc_xa.entity.MucDoViPham;

import java.util.List;

public interface IMucDoViPhamRepository{
    List<MucDoViPham> findAll();
}
