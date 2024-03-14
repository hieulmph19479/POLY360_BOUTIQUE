package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "khuyen_mai")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Không được để trống")
    @Length(min = 5,max = 50, message = " Không dưới 5 kí tự và quá 50 kí tự")
    @Column(name = "ma_khuyen_mai")
    private String maKhuyenMai;

    @NotBlank(message = "Không được để trống")
    @Length(max = 100, message = "Không quá 100 kí tự")
    @Column(name = "ten_khuyen_mai")
    private String tenKhuyenMai;

    @NotNull(message = "Ngày tạo không được để trống")
    @Past(message = "Ngày tạo phải trước ngày hiện tại")
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;

    @NotNull(message = "Ngày kết thúc không được để trống")
    @Future(message = "Ngày kết thúc phải sau ngày hiện tại")
    @Column(name = "ngay_ket_thuc")
    private LocalDateTime ngayKetThuc;

    @NotNull(message = "Ngày cập nhật không được để trống")
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;

    @Column(name = "trang_thai")
    private Long trangThai;

    @OneToMany(mappedBy = "khuyenMai", fetch = FetchType.EAGER)
    private List<ChiTietKhuyenMai> chiTietKhuyenMaiList;

}
