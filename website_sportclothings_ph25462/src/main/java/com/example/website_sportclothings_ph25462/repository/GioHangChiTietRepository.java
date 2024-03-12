package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Long> {

    @Query(value = "select * from gio_Hang_Chi_Tiet where gio_hang_id = :idGioHang",nativeQuery = true)
    List<GioHangChiTiet> getGioHangChiTietByIdGioHang(@Param("idGioHang") Long idGioHang);


}
