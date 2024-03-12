package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, Long> {
    @Query(value = "SELECT * FROM ChiTietSP ",nativeQuery = true)
    List<ChiTietSP> getAll();
}
