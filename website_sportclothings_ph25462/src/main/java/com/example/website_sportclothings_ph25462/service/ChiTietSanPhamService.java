package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChiTietSanPhamService {

    Page<ChiTietSanPham> getData(Integer page);


    ChiTietSanPham getOne(Long id);

    List<ChiTietSanPham> getAll();

    List<ChiTietSanPham> getCTSPByIdSanPham(long id);

    ChiTietSanPham getCTSPByIdSanPhamAndIdMauSacAndIdKichCo(long idSP, long idMauSac, long idKchCo);




}