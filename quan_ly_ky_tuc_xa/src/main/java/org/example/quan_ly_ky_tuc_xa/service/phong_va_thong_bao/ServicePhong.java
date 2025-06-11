package org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.Phong;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.IRepoPhong;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.RepoPhong;

import java.util.List;

public class ServicePhong implements IServicePhong{
    private IRepoPhong repoPhong=new RepoPhong();
    @Override
    public List<Phong> findAll() {
        return repoPhong.findAll();
    }

    @Override
    public boolean add(Phong phong) {
        return repoPhong.add(phong);
    }

    @Override
    public boolean edit(Phong phong) {
        return repoPhong.edit(phong);
    }

    @Override
    public boolean delete(int id) {
        return repoPhong.delete(id);
    }

    @Override
    public List<Phong> search(String name,int idLoaiPhong) {
        return repoPhong.search(name,idLoaiPhong);
    }

    @Override
    public Phong findById(int id) {
        return repoPhong.findById(id);
    }
}
