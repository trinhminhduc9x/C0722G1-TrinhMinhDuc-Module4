package com.laptopshop.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.laptopshop.model.DonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.laptopshop.dto.SearchDonHangObject;

import com.laptopshop.repository.DonHangRepository;
import com.laptopshop.service.DonHangService;

import com.laptopshop.model.NguoiDung;
@Service
public class DonHangServiceImpl implements DonHangService {

	@Autowired
	private DonHangRepository donHangRepo;


	@Override
	public Page<DonHang> getAllDonHangByFilter(SearchDonHangObject object, int page) throws ParseException {
		return null;
	}

	@Override
	public DonHang update(DonHang dh) {
		return donHangRepo.save(dh);
	}

	@Override
	public DonHang findById(long id) {
		return donHangRepo.findById(id).get();
	}

	@Override
	public Page<DonHang> findDonHangByShipper(SearchDonHangObject object, int page, int size, NguoiDung shipper) throws ParseException {
		return null;
	}

	@Override
	public List<DonHang> findByTrangThaiDonHangAndShipper(String trangThai, NguoiDung shipper) {
		return donHangRepo.findByTrangThaiDonHangAndShipper(trangThai, shipper);
	}

	@Override
	public DonHang save(DonHang dh) {
		return donHangRepo.save(dh);
	}

	@Override
	public List<Object> layDonHangTheoThangVaNam() {
		return donHangRepo.layDonHangTheoThangVaNam();
	}
	
	@Override
	public List<DonHang> getDonHangByNguoiDung(NguoiDung ng) {
		return donHangRepo.findByNguoiDat(ng);
	}


	@Override
	public int countByTrangThaiDonHang(String trangThaiDonHang) {
		return donHangRepo.countByTrangThaiDonHang(trangThaiDonHang);
	}

}
