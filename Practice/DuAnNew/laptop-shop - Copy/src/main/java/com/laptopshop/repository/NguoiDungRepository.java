package com.laptopshop.repository;

import java.util.List;
import java.util.Set;

import com.laptopshop.model.NguoiDung;
import com.laptopshop.model.VaiTro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{

	NguoiDung findByEmail(String email);

	Page<NguoiDung> findByVaiTro(Set<VaiTro> vaiTro, Pageable of);

	List<NguoiDung> findByVaiTro(Set<VaiTro> vaiTro);
}
