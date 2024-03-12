package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Table(name = "voucher")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ma_voucher")
    private String maVC;
    @Column(name = "ten_voucher")
    private String tenVC;
    @Column(name = "ngay_bat_dau")
    private LocalDateTime ngayBD;
    @Column(name = "ngay_ket_thuc")
    private LocalDateTime ngayKT;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "phan_tram_giam")
    private String phanTram;
    @Column(name = "giam_gia_toi_da")
    private Float giamGiaTD;
    @Column(name = "gia_tri_don_toi_thieu")
    private String giaTriTT;

}
