package com.laptopshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.laptopshop.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.laptopshop.dto.SanPhamDto;
import com.laptopshop.dto.SearchSanPhamObject;

import com.laptopshop.repository.DanhMucRepository;
import com.laptopshop.repository.HangSanXuatRepository;
import com.laptopshop.repository.SanPhamRepository;
import com.laptopshop.service.SanPhamService;


@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	private SanPhamRepository sanPhamRepo;

	@Autowired
	private DanhMucRepository danhMucRepo;

	@Autowired
	private HangSanXuatRepository hangSanXuatRepo;

	// đổi từ SanPhamDto sang đối tượng SanPham để add vào db
	public SanPham convertFromSanPhamDto(SanPhamDto dto) {
		SanPham sanPham = new SanPham();
		if (!dto.getId().equals("")) {
			sanPham.setId(Long.parseLong(dto.getId()));
		}
		sanPham.setTenSanPham(dto.getTenSanPham());
		sanPham.setCpu(dto.getCpu());
		sanPham.setDanhMuc(danhMucRepo.findById(dto.getDanhMucId()).get());
		sanPham.setHangSanXuat(hangSanXuatRepo.findById(dto.getNhaSXId()).get());
		sanPham.setDonGia(Long.parseLong(dto.getDonGia()));
		sanPham.setThietKe(dto.getThietKe());
		sanPham.setThongTinBaoHanh(dto.getThongTinBaoHanh());
		sanPham.setThongTinChung(dto.getThongTinChung());
		sanPham.setManHinh(dto.getManHinh());
		sanPham.setRam(dto.getRam());
		sanPham.setDungLuongPin(dto.getDungLuongPin());
		sanPham.setDonViKho(Integer.parseInt(dto.getDonViKho()));
		sanPham.setHeDieuHanh(dto.getHeDieuHanh());

		return sanPham;
	}

	@Override
	public SanPham save(SanPhamDto dto) {
		SanPham sp = convertFromSanPhamDto(dto);
		System.out.println(sp);
		return sanPhamRepo.save(sp);
	}

	@Override
	public SanPham update(SanPhamDto dto) {
		return sanPhamRepo.save(convertFromSanPhamDto(dto));
	}

	@Override
	public void deleteById(long id) {
		sanPhamRepo.deleteById(id);

	}

	@Override
	public Page<SanPham> getAllSanPhamByFilter(SearchSanPhamObject object, int page, int limit) {
		return null;
	}

	@Override
	public SanPham getSanPhamById(long id) {
		return null;
	}


	@Override
	public List<SanPham> getLatestSanPham() {
		return sanPhamRepo.findFirst12ByDanhMucTenDanhMucContainingIgnoreCaseOrderByIdDesc("Laptop");
	}

	@Override
	public Iterable<SanPham> getSanPhamByTenSanPhamWithoutPaginate(SearchSanPhamObject object) {
		return null;
	}

	@Override
	public Page<SanPham> getSanPhamByTenSanPham(SearchSanPhamObject object, int page, int resultPerPage) {
		return null;
	}


	// Tim kiem san pham theo keyword, sap xep, phan trang, loc theo muc gia, lay 12
	// san pham moi trang

	public List<SanPham> getAllSanPhamByList(Set<Long> idList) {
		return sanPhamRepo.findByIdIn(idList);
	}

	@Override
	public Page<SanPham> getSanPhamByTenSanPhamForAdmin(String tenSanPham, int page, int size) {
		return null;
	}

	@Override
	public Iterable<SanPham> getSanPhamByTenDanhMuc(String brand) {
		return null;
	}

	@Override
	public Page<SanPham> getSanPhamByBrand(SearchSanPhamObject object, int page, int resultPerPage) {
		return null;
	}


}
