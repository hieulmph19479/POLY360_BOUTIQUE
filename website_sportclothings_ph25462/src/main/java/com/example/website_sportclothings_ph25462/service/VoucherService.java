package com.example.website_sportclothings_ph25462.service;

import com.example.website_sportclothings_ph25462.entity.VaiTro;
import com.example.website_sportclothings_ph25462.entity.Voucher;

import java.util.List;

public interface VoucherService {
    List<Voucher> getAll();

    void add(Voucher voucher);
}
