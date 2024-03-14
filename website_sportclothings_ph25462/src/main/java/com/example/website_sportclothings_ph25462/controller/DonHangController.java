package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.HoaDonChiTiet;
import com.example.website_sportclothings_ph25462.entity.TaiKhoan;
import com.example.website_sportclothings_ph25462.security.TaiKhoanDangDangNhap;
import com.example.website_sportclothings_ph25462.service.HoaDonChiTietService;
import com.example.website_sportclothings_ph25462.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DonHangController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private TaiKhoanDangDangNhap taiKhoanDangDangNhap;

    @GetMapping("/donHang")
    public String hienThi(Model model){
        List<HoaDon> hoaDonList = hoaDonService.getAll();

        model.addAttribute("donHangList",hoaDonList);
        return "/don_hang/don-hang";
    }

    @GetMapping("/donHang/donHangChiTiet/{idDonHang}")
    public String orderDetail(Model model, @PathVariable long idDonHang) {

        TaiKhoan taiKhoan = taiKhoanDangDangNhap.getCurrentNguoiDung();
        try {
            if (taiKhoan == null) {
                return "redirect:/login";
            }
            if (taiKhoan != null) {
                List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietService.getHDCTByIdHoaDon(idDonHang);
                model.addAttribute("donHangChiTietList", hoaDonChiTietList);
                model.addAttribute("maDonHang", hoaDonChiTietList.get(0).getHoaDon().getMaHoaDon());
                model.addAttribute("tongTien", hoaDonChiTietList.get(0).getHoaDon().getTongTien());
                return "/don_hang/don-hang-chi-tiet";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/don_hang/don-hang-chi-tiet";
    }


}
