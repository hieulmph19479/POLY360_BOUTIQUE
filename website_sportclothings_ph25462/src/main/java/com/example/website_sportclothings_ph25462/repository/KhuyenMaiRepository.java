package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Long> {
    @Query(value = "SELECT * \n" +
            "FROM khuyen_mai km \n" +
            "WHERE km.ten_khuyen_mai LIKE '%Khuyến mại 1%' \n" +
            "OR km.ma_khuyen_mai LIKE '%KM01%'; ",nativeQuery = true)
    List<KhuyenMai> searchKhuyenMaiBy(String key);

}
