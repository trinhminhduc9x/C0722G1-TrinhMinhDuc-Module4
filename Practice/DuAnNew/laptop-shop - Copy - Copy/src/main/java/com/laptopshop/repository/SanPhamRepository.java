package com.laptopshop.repository;

import java.util.List;
import java.util.Set;

import com.laptopshop.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;



public interface SanPhamRepository extends JpaRepository<SanPham, Long>{

	
	List<SanPham> findFirst12ByDanhMucTenDanhMucContainingIgnoreCaseOrderByIdDesc(String dm);
	List<SanPham> findByIdIn(Set<Long> idList);
}
