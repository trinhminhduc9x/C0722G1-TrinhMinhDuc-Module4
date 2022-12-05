package com.laptopshop.service;

import java.util.List;

import com.laptopshop.model.DanhMuc;
import org.springframework.data.domain.Page;



public interface DanhMucService {

	Page<DanhMuc> getAllDanhMucForPageable(int page, int size);

	List<DanhMuc> getAllDanhMuc();

	DanhMuc getDanhMucById(long id);

	DanhMuc save(DanhMuc d);

	DanhMuc update(DanhMuc d);

	void deleteById(long id);
}
