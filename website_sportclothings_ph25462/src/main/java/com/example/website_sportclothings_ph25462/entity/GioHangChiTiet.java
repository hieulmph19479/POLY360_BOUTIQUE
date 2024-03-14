package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "gio_hang_chi_tiet")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
    @Column(name = "trang_thai")
    private Boolean tt;

//    @OneToOne()
//    @JoinColumn(name = "chi_tiet_san_pham_id")
//    private ChiTietSanPham chiTietSanPham;

    @OneToOne()
    @JoinColumn(name = "gio_hang_id")
    private GioHang gioHang;


}
