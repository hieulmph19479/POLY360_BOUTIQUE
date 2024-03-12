package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import com.example.website_sportclothings_ph25462.repository.ChiTietSPRepository;
import com.example.website_sportclothings_ph25462.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSPRepository chiTietSPRepository;

    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSPRepository.findAll();

    }

    @Override
    public void remove(Long id) {

        chiTietSPRepository.deleteById(id);
    }

    @Override
    public void save(ChiTietSP chiTietSP) {
        chiTietSPRepository.save(chiTietSP);
    }


}
