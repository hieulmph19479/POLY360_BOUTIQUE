package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChiTietKhuyenMai;
import com.example.website_sportclothings_ph25462.repository.ChiTietKhuyenMaiRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietKhuyenMaiServiceImpl implements ChiTietKhuyenMaiService {

    @Autowired
    ChiTietKhuyenMaiRepository chiTietKhuyenMaiRepository;

    @Override
    public List<ChiTietKhuyenMai> getAll() {

        return chiTietKhuyenMaiRepository.findAll();
    }

    @Override
    public void add(ChiTietKhuyenMai chiTietKhuyenMai) {
        chiTietKhuyenMaiRepository.save(chiTietKhuyenMai);
    }

    @Override
    public ChiTietKhuyenMai update(Long id) {
        return chiTietKhuyenMaiRepository.findById(id).orElse(null);
    }


    @Override
    public void remove(Long id) {
        chiTietKhuyenMaiRepository.deleteById(id);
    }
}
