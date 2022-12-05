package com.laptopshop.repository;

import java.util.List;

import com.laptopshop.model.ChiMucGioHang;
import com.laptopshop.model.GioHang;
import com.laptopshop.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiMucGioHangRepository extends JpaRepository<ChiMucGioHang, Long>{
	
	ChiMucGioHang findBySanPhamAndGioHang(SanPham sp, GioHang g);
	
	List<ChiMucGioHang> findByGioHang(GioHang g);
}
