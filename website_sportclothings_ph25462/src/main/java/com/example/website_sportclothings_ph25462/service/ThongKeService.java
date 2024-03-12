package com.example.website_sportclothings_ph25462.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public interface ThongKeService {

    Long getRevenue(int day, int month, int year);

    Long getTongSoLuongBanNgayThangNam(LocalDateTime startDate, LocalDateTime endDate);

    Long getTongSoLuongHoaDonBanNgayThangNam(LocalDateTime startDate, LocalDateTime endDate);


    Map<String ,Long> getThongKeDoanhThuTheoThang();
}
