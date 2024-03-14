package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.repository.ChiTietSPRepository;
import com.example.website_sportclothings_ph25462.repository.KhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;

    @Autowired
    ChiTietSPRepository chiTietSPRepository;

    @Override
    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public KhuyenMai add(KhuyenMai khuyenMai) {
        return khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void remove(Long id) {
        khuyenMaiRepository.deleteById(id);
    }

    @Override
    public KhuyenMai update(Long id) {
        KhuyenMai khuyenMaiUpdate = khuyenMaiRepository.findById(id).orElse(null);
        khuyenMaiUpdate.setTenKhuyenMai(khuyenMaiUpdate.getTenKhuyenMai());
        khuyenMaiUpdate.setNgayTao(khuyenMaiUpdate.getNgayTao());
        khuyenMaiUpdate.setNgayKetThuc(khuyenMaiUpdate.getNgayKetThuc());
        khuyenMaiUpdate.setNgayCapNhat(khuyenMaiUpdate.getNgayCapNhat());
        khuyenMaiUpdate.setTrangThai(khuyenMaiUpdate.getTrangThai());

        khuyenMaiRepository.save(khuyenMaiUpdate);

        List<ChiTietKhuyenMai> chiTietKhuyenMaiList = khuyenMaiUpdate.getChiTietKhuyenMaiList();

        if (chiTietKhuyenMaiList != null) {
            if (khuyenMaiUpdate.getTrangThai() == 4) {
                for (ChiTietKhuyenMai ctkm : chiTietKhuyenMaiList) {
                    ChiTietSP chiTietSP = ctkm.getChiTietSP();
                    chiTietSP.setGiaHienHanh(chiTietSP.getGiaGoc());
                    chiTietSPRepository.save(chiTietSP);
                }
            } else if (khuyenMaiUpdate.getTrangThai() == 2 || khuyenMaiUpdate.getTrangThai() == 1) {
                for (ChiTietKhuyenMai chiTietKhuyenMai : chiTietKhuyenMaiList) {
                    ChiTietSP chiTietSP = chiTietKhuyenMai.getChiTietSP();
                    if (chiTietKhuyenMai.getHinhThucGiam() == 1) {
                        chiTietSP.setGiaHienHanh((long) (chiTietSP.getGiaGoc() * (100 - chiTietKhuyenMai.getGiaTriGiam()) / 100));
                    }
                    chiTietSPRepository.save(chiTietSP);
                }

            }
        }

        return khuyenMaiRepository.findById(id).orElse(null);
    }

    @Override
    public List<KhuyenMai> search(String key) {
        return khuyenMaiRepository.searchKhuyenMaiBy(key);
    }

}
