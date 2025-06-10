package org.example.quan_ly_ky_tuc_xa.service.phong_va_thong_bao;

import org.example.quan_ly_ky_tuc_xa.entity.phong_va_thong_bao.ThongBao;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.IRepoThongBao;
import org.example.quan_ly_ky_tuc_xa.repository.phong_va_thong_bao.RepoThongBao;

import java.util.List;

public class ServiceThongBao implements IServiceThongBao{
    private IRepoThongBao repoThongBao=new RepoThongBao();
    @Override
    public void sendNotification(ThongBao tb) {
        repoThongBao.sendNotification(tb);
    }

    @Override
    public List<ThongBao> findAll() {
        return repoThongBao.findAll();
    }
}
