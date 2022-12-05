package com.laptopshop.repository;

import com.laptopshop.model.LienHe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;



public interface LienHeRepository extends JpaRepository<LienHe, Long>, QuerydslPredicateExecutor<LienHe>{

	int countByTrangThai(String trangThai);
	
}
