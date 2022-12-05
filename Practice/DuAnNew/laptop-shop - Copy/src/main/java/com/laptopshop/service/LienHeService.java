package com.laptopshop.service;

import java.text.ParseException;

import com.laptopshop.model.LienHe;
import org.springframework.data.domain.Page;

import com.laptopshop.dto.SearchLienHeObject;


public interface LienHeService {

	Page<LienHe> getLienHeByFilter(SearchLienHeObject object, int page) throws ParseException;

	LienHe findById(long id);
	
	LienHe save(LienHe lh);
	
	int countByTrangThai(String trangThai);

}
