package com.laptopshop.service;

import com.laptopshop.model.ChiMucGioHang;
import com.laptopshop.model.GioHang;
import com.laptopshop.model.SanPham;

import java.util.List;



public interface ChiMucGioHangService{
	
	List<ChiMucGioHang> getChiMucGioHangByGioHang(GioHang g);
	
	ChiMucGioHang getChiMucGioHangBySanPhamAndGioHang(SanPham sp, GioHang g);
	
	ChiMucGioHang saveChiMucGiohang(ChiMucGioHang c);
	
	void deleteChiMucGiohang(ChiMucGioHang c);
	
	void deleteAllChiMucGiohang(List<ChiMucGioHang> c);
	
}
