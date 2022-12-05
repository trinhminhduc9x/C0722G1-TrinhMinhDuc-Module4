package com.laptopshop.service;


import com.laptopshop.model.GioHang;
import com.laptopshop.model.NguoiDung;

public interface GioHangService {
	
	GioHang getGioHangByNguoiDung(NguoiDung n);
	
	GioHang save(GioHang g);
}
