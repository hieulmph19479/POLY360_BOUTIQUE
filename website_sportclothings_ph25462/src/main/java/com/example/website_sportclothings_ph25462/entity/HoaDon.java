package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Hoa_Don")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @Column(name = "ma_hoa_don")
    private String maHoaDon;

    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;

    @Column(name = "loai_hoa_don")
    private String loaiHoaDon;

    @Column(name = "phi_giao_hang")
    private Long phiGiaoHang;

    @Column(name = "tong_tien")
    private Long tongTien;

    @Column(name = "gia_phai_tra")
    private Long giaPhaiTra;

    @Column(name = "ghi_chu", columnDefinition = "NVARCHAR(MAX)")
    private String ghiChu;

    @Column(name = "nguoi_nhan")
    private String nguoiNhan;

    @Column(name = "sdt_nguoi_nhan")
    private Integer sdtNguoiNhan;

    @Column(name = "dia_chi_nguoi_nhan", columnDefinition = "NVARCHAR(MAX)")
    private String diaChiNguoiNhan;

    @Column(name = "phuong_xa")
    private String phuongXa;

    @Column(name = "quan_huyen")
    private String quanHuyen;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "ngay_nhan")
    private Date ngayNhan;

    @Column(name = "ngay_mong_muon")
    private Date ngayMongMuon;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;

    @Column(name = "trang_thai")
    private Integer trangThai;

//    @ManyToOne
//    @JoinColumn(name = "vouver_id")
//    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "tai_khoan_id")
    private TaiKhoan taiKhoan;

//    @ManyToOne
//    @JoinColumn(name = "phuong_thuc_thanh_toan_id")
//    private PhuongThucThanhToan phuongThucThanhToan;


}
