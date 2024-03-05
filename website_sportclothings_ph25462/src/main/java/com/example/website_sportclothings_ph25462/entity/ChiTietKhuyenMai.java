package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "chi_tiet_khuyen_mai")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietKhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ma_chi_tiet_khuyen_mai")
    private String maChiTietKhuyenMai;

    @Column(name = "hinh_thuc_giam")
    private Integer hinhThucGiam; //1 theo % : 2 theo hóa đơn thành viên//

    @Column(name = "gia_tri_giam")
    private Long giaTriGiam; //giá trị giảm == giá trị bên khuyến mại//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chi_tiet_san_pham", referencedColumnName = "id")
    private ChiTietSP chiTietSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_khuyen_mai", referencedColumnName = "id")
    private KhuyenMai khuyenMai;

    @Column(name = "ngay_bat_dau")
    private LocalDateTime ngayBatDau;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
