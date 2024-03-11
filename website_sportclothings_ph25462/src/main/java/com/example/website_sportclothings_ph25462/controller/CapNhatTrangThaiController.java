package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.service.ChiTietSPService;
import com.example.website_sportclothings_ph25462.service.KhuyenMaiService;
import com.example.website_sportclothings_ph25462.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CapNhatTrangThaiController {
    @Autowired
    KhuyenMaiService khuyenMaiService;

    @Autowired
    ChiTietSPService chiTietSPService;

    @Autowired
    VoucherService voucherService;
//    @Scheduled(cron = "0 00  24 * * ?") // 0h everyday
    public void run() {
        LocalDateTime now = LocalDateTime.now();

        for (KhuyenMai khuyenMai : khuyenMaiService.getAll()) {
            if (khuyenMai.getTrangThai() == 1 && khuyenMai.getNgayTao().isBefore(now)) {
                khuyenMai.setTrangThai(2L); //sắp diễn ra -> đang hoạt động//
                khuyenMaiService.add(khuyenMai);
                List<ChiTietKhuyenMai> chiTietKhuyenMaiList = khuyenMai.getChiTietKhuyenMaiList();
                if (chiTietKhuyenMaiList != null) {
                    for (ChiTietKhuyenMai chiTietKhuyenMai : chiTietKhuyenMaiList) {
                        ChiTietSP chiTietSP = chiTietKhuyenMai.getChiTietSP();
                        if (chiTietKhuyenMai.getHinhThucGiam() == 1) {
                            chiTietSP.setGiaHienHanh((long) 100 - ((chiTietKhuyenMai.getGiaTriGiam()) / 100));
                        }
                        chiTietSPService.save(chiTietSP);
                    }
                }
            }
        }
    }
}
