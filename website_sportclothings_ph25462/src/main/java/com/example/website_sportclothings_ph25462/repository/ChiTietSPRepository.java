package com.example.website_sportclothings_ph25462.repository;

import com.example.website_sportclothings_ph25462.entity.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, Long> {
//    @Query(value = "SELECT * FROM ChiTietSP ",nativeQuery = true)
//    List<ChiTietSP> getAll();
//    @Query(
//            value = "SELECT * FROM chi_Tiet_san_pham where san_pham_id = :id ",
//            nativeQuery = true
//    )
//    List<ChiTietSanPham> getAllByIdSanPham(@Param("id") long id);
//
//
//    @Query(
//            value = "SELECT * FROM chi_Tiet_san_pham where san_pham_id = :idSP and mau_sac_id = :idMauSac and kich_co_id = :idKichCo ",
//            nativeQuery = true
//    )
//    ChiTietSanPham getAllByIdSanPhamAndIdMauSacAndIdKichCo(@Param("idSP") long idSP, @Param("idMauSac") long idMauSac, @Param("idKichCo") long idKichCo);
}
