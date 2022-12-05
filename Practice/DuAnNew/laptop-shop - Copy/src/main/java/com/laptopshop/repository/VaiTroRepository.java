package com.laptopshop.repository;

import com.laptopshop.model.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
