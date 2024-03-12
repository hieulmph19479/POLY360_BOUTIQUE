package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.GioHang;
import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.repository.GioHangChiTietRepository;
import com.example.website_sportclothings_ph25462.repository.GioHangRepository;
import com.example.website_sportclothings_ph25462.repository.KhachHangRepository;
import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;


    @Override
    public List<GioHangChiTiet> getAllByKhachHang(KhachHang khachHang) {

//        khachHang = khachHangRepository.findById(1L).orElse(null);
//        GioHang gioHang = gioHangRepository.getGioHangByNguoiSoHuu(khachHang);

        return gioHangChiTietRepository.getGioHangChiTietByIdGioHang(1L);
    }

    @Override
    public List<GioHangChiTiet> getAll() {
        return gioHangChiTietRepository.findAll();
    }

    @Override
    public GioHangChiTiet add(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet update(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public void delete(Long id) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findById(id).orElse(null);
        gioHangChiTietRepository.delete(gioHangChiTiet);
    }
}
