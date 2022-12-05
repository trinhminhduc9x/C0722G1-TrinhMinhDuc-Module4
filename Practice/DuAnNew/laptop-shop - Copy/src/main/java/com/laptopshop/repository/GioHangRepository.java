package com.laptopshop.repository;

import com.laptopshop.model.GioHang;
import com.laptopshop.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;



public interface GioHangRepository extends JpaRepository<GioHang, Long>{
	
	GioHang findByNguoiDung(NguoiDung n);
	
}
