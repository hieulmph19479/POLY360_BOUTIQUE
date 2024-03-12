package com.example.website_sportclothings_ph25462.repository;


import com.example.website_sportclothings_ph25462.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

    @Query(value = " SELECT TOP 1 id FROM hoa_don ORDER BY id DESC ", nativeQuery = true)
    Long gietIdMax();


}
