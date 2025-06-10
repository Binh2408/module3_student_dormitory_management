package org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.LoaiPhong;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.IRepoLoaiPhong;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.RepoLoaiPhong;

import java.util.List;

public class ServiceLoaiPhong implements IServiceLoaiPhong{
    private IRepoLoaiPhong repoLoaiPhong=new RepoLoaiPhong();

    @Override
    public List<LoaiPhong> findAll() {
        return repoLoaiPhong.findAll();
    }
}
