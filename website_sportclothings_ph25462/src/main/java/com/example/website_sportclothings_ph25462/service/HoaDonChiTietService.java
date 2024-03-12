package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.HoaDonChiTiet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();
}
