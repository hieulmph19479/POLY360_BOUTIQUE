package com.example.website_sportclothings_ph25462.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

//    @NotBlank(message = "Mã chi tiết khuyến mãi không được để trống")
//    @Size(min = 5, max = 50, message = "Mã chi tiết khuyến mãi phải từ 5 đến 50 ký tự")
    @Column(name = "ma_chi_tiet_khuyen_mai")
    private String maChiTietKhuyenMai;


    @Column(name = "hinh_thuc_giam")
    private Integer hinhThucGiam; //1 theo % : 2 theo hóa đơn thành viên//

//    @NotNull(message = "Giá trị giảm không được để trống")
    @Column(name = "gia_tri_giam")
    private Long giaTriGiam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chi_tiet_san_pham", referencedColumnName = "id")
    private ChiTietSP chiTietSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_khuyen_mai", referencedColumnName = "id")
    private KhuyenMai khuyenMai;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
