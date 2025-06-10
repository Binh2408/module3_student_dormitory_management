package org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.TrangThaiPhong;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.IRepoTrangThaiPhong;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.RepoTrangThaiPhong;

import java.util.List;

public class ServiceTrangThaiPhong implements IServiceTrangThaiPhong{
    private IRepoTrangThaiPhong repoTrangThaiPhong=new RepoTrangThaiPhong();

    @Override
    public List<TrangThaiPhong> findAll() {
        return repoTrangThaiPhong.findAll();
    }
}
