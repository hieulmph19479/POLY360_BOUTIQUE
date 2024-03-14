package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Table(name = "tai_khoan")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ma_tai_khoan")
    private String ma;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "so_dien_thoai")
    private Integer sdt;

    @NotBlank(message = "Email khong duoc de trong")
    @Column(name = "email")
    private String email;
    @NotBlank(message = "Ten tai khoan khong duoc de trong")
    @Column(name = "ten_tai_khoan")
    private String tenTK;
    @NotBlank(message = "Mat khau khong duoc de trong")

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "trang_thai")
    private Boolean tt;

    @OneToOne()
    @JoinColumn(name = "vai_tro_id")
    private VaiTro vaiTro;
}
