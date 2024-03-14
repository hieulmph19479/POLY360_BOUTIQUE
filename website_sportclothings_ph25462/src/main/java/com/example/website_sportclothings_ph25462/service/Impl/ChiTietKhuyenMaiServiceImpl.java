package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import com.example.website_sportclothings_ph25462.repository.ChiTietKhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.repository.ChiTietSPRepository;
import com.example.website_sportclothings_ph25462.repository.KhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietKhuyenMaiServiceImpl implements ChiTietKhuyenMaiService {


    @Autowired
    ChiTietKhuyenMaiRepository chiTietKhuyenMaiRepository;

    @Autowired
    KhuyenMaiRepository khuyenMaiRepository;
    @Autowired
    ChiTietSPRepository chiTietSPRepository;

    @Override
    public List<ChiTietKhuyenMai> getAll() {

        return chiTietKhuyenMaiRepository.findAll();
    }

//    @Override
//    public ChiTietKhuyenMai add(ChiTietKhuyenMai chiTietKhuyenMai) {
//        chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
//        Optional<KhuyenMai> khuyenMaiOptional = khuyenMaiRepository.findById(chiTietKhuyenMai.getKhuyenMai().getId());
//        if (khuyenMaiOptional.isPresent()) {
//            KhuyenMai khuyenMai = khuyenMaiOptional.get();
//            Integer trangThai = Math.toIntExact(khuyenMai.getTrangThai());
//            if (trangThai != null && trangThai == 1) {
//                for (ChiTietKhuyenMai ctkm : khuyenMai.getChiTietKhuyenMaiList()) {
//                    Optional<ChiTietSP> chiTietSPOptional = chiTietSPRepository.findById(ctkm.getChiTietSP().getId());
//                    if (chiTietSPOptional.isPresent()) {
//                        ChiTietSP chiTietSP = chiTietSPOptional.get();
//                        if (chiTietKhuyenMai.getHinhThucGiam() == 1) {
//                            chiTietSP.setGiaHienHanh((long) (chiTietSP.getGiaGoc() * (100 - chiTietKhuyenMai.getGiaTriGiam()) / 100));
//                        }
//                        chiTietSPRepository.save(chiTietSP);
//                    }
//                }
//            }
//        }
//        return chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
//    }

    @Override
    public ChiTietKhuyenMai update(Long id) {

        return chiTietKhuyenMaiRepository.findById(id).orElse(null);
    }


    @Override
    public void remove(Long id) {
        chiTietKhuyenMaiRepository.deleteById(id);
    }
}
