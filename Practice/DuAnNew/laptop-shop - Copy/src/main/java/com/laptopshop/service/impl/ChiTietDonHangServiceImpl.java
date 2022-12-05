package com.laptopshop.service.impl;

import java.util.List;

import com.laptopshop.model.ChiTietDonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.laptopshop.repository.ChiMucGioHangRepository;
import com.laptopshop.repository.ChiTietDonHangRepository;
import com.laptopshop.service.ChiTietDonHangService;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{
	
	@Autowired
	private ChiTietDonHangRepository repo;
	
	@Override
	public List<ChiTietDonHang> save(List<ChiTietDonHang> list)
	{	
		return repo.saveAll(list);
	}
}
