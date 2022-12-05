package com.laptopshop.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.laptopshop.model.LienHe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.laptopshop.dto.LienHeDTO;
import com.laptopshop.dto.SearchLienHeObject;

import com.laptopshop.repository.LienHeRepository;
import com.laptopshop.service.LienHeService;


@Service
public class LienHeServiceImpl implements LienHeService {

	@Autowired
	private LienHeRepository lienHeRepo;


	@Override
	public Page<LienHe> getLienHeByFilter(SearchLienHeObject object, int page) throws ParseException {
		return null;
	}

	@Override
	public LienHe findById(long id) {
		return lienHeRepo.findById(id).get();
	}

	@Override
	public LienHe save(LienHe lh) {
		return lienHeRepo.save(lh);
	}

	@Override
	public int countByTrangThai(String trangThai) {
		return lienHeRepo.countByTrangThai(trangThai);
	}

}
