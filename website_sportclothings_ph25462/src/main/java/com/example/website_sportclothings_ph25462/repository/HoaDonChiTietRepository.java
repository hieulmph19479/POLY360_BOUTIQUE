package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Long> {

    @Query(value = "select * from hoa_Don_chi_tiet where hoa_don_id = :id ", nativeQuery = true)
    public List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(@Param("id") Long id);
}
