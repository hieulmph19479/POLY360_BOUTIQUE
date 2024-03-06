package com.example.website_sportclothings_ph25462.service;


import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.entity.KhuyenMai;

import java.util.List;
import java.util.UUID;

public interface ChiTietKhuyenMaiService {
    List<ChiTietKhuyenMai> getAll();

    void add(ChiTietKhuyenMai chiTietKhuyenMai);

    ChiTietKhuyenMai update(Long id);

    void remove(Long id);
}
