package com.laptopshop.service;

import java.util.List;

import com.laptopshop.model.HangSanXuat;
import org.springframework.data.domain.Page;



public interface HangSanXuatService {

	List<HangSanXuat> getALlHangSX();
	
	Page<HangSanXuat> getALlHangSX(int page, int size);

	HangSanXuat getHSXById(long id);

	HangSanXuat save(HangSanXuat h);

	HangSanXuat update(HangSanXuat h);

	void deleteById(long id);
}
