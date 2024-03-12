package com.example.website_sportclothings_ph25462.service.Impl;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.HoaDonChiTiet;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.repository.ChiTietSanPhamRepository;
import com.example.website_sportclothings_ph25462.repository.HoaDonChiTietRepository;
import com.example.website_sportclothings_ph25462.repository.HoaDonRepository;
import com.example.website_sportclothings_ph25462.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;



    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet getOne(Long id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        hoaDonChiTietRepository.delete(getOne(id));
    }

    @Override
    public HoaDon createOrder(KhachHang kh, String address, List<GioHangChiTiet> gioHangChiTietList, Long phiVanChuyen) {

        HoaDon hoaDon = new HoaDon();
        hoaDon.setKhachHang(kh);
        hoaDon.setDiaChiNguoiNhan(address);

        long total = 0;
        for (GioHangChiTiet gioHangChiTiet : gioHangChiTietList) {
            total += gioHangChiTiet.getSoLuong() * gioHangChiTiet.getChiTietSanPham().getGia(); // lấy tổng tiền
        }
        hoaDon.setTongTien(total + phiVanChuyen);
        hoaDon.setNgayTao(new Date());
        hoaDon.setTrangThai(2); //  <!-- 2: Chờ Xác nhận, 3: Đã Xác nhận, 4: dang van chuyen, 1: thanh cong, 0: huy bo-->
//        hoaDon.setTrangThaiThanhToan(0); // trạng thái thanh toán hay chưa

        Long idMax = 0L; // lấy ID lớn nhất làm mã Đơn Hàng
        if (hoaDonRepository.gietIdMax() == null) {
            idMax = 1L;
        } else if (hoaDonRepository.gietIdMax() != null) {
            idMax = hoaDonRepository.gietIdMax() + 1;
        }
        hoaDon.setMaHoaDon("HD" + idMax.toString());

        hoaDonRepository.save(hoaDon);

        for (GioHangChiTiet carts : gioHangChiTietList) {
            HoaDonChiTiet orderDetail = new HoaDonChiTiet();
            orderDetail.setHoaDon(hoaDon);
            orderDetail.setDonGia(carts.getChiTietSanPham().getGia());
            orderDetail.setSoLuong(carts.getSoLuong());

            orderDetail.setChiTietSanPham(
                    chiTietSanPhamRepository.findById(carts.getChiTietSanPham().getId()).orElse(null)
            );
//            orderDetail.setTrangThaiTraHang(0);

            HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.save(orderDetail);

        }

        return hoaDon;

    }
}
