package com.example.website_sportclothings_ph25462.controller;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import com.example.website_sportclothings_ph25462.entity.HoaDon;
import com.example.website_sportclothings_ph25462.entity.KhachHang;
import com.example.website_sportclothings_ph25462.repository.DiaChiRepository;
import com.example.website_sportclothings_ph25462.service.GioHangChiTietService;
import com.example.website_sportclothings_ph25462.service.HoaDonChiTietService;
import com.example.website_sportclothings_ph25462.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

//    @Autowired
//    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private DiaChiRepository diaChiRepository;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private HttpSession session;


    @GetMapping("/show")
    public String showCheckout(Model model) {

        try {
            model.addAttribute("diaChiList", diaChiRepository.findAll()); // phải hiển thị địa chỉ theo khách hàng dang đăng nhập.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/checkout/checkout";
    }


    @PostMapping("/process")
    public String processCheckout(@RequestParam String address, String shippingFee, Model model) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        KhachHang kh = khachHangRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        KhachHang khachHang = khachHangService.getOneById(1L);
        List<GioHangChiTiet> carts = gioHangChiTietService.getAllByKhachHang(khachHang);

        if (carts != null && !carts.isEmpty()) {
            Long phiVanChuyen = 30000L; // tạm để mạc định phí GH = 30k
            try {
                phiVanChuyen = Long.parseLong(shippingFee);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // tạo một đối tượng DonHang mới và lưu vào cơ sở dữ liệu
            HoaDon order = hoaDonChiTietService.createOrder(khachHang, address, carts, phiVanChuyen);

            // Xóa giỏ hàng
//            gioHangChiTietService.clearCart();

            model.addAttribute("order", order);

            return "redirect:/checkout/success";
        } else {
            return "redirect:/checkout/show";
        }
    }


    @GetMapping("/success")
    public String showCheckoutSuccess(Model model) {

        return "/checkout/checkout-success";

    }


    @ModelAttribute(name = "carts")
    public List<GioHangChiTiet> cartItems() {
        List<GioHangChiTiet> gioHangChiTietList = gioHangChiTietService.getAll(); // getAll theo giỏ hàng của khách hàng

        return gioHangChiTietList;
    }


}
