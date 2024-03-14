package com.example.website_sportclothings_ph25462.service;


import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;

import java.util.List;

public interface ChiTietKhuyenMaiService {
    List<ChiTietKhuyenMai> getAll();

    ChiTietKhuyenMai add(ChiTietKhuyenMai chiTietKhuyenMai);

    ChiTietKhuyenMai update(ChiTietKhuyenMai chiTietKhuyenMai,Long id);

    void remove(Long id);
}
