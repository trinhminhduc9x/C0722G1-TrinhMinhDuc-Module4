package com.laptopshop.controller;

import java.util.ArrayList;
import java.util.Collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



import com.laptopshop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.laptopshop.dto.SearchSanPhamObject;

import com.laptopshop.service.DanhMucService;
import com.laptopshop.service.SanPhamService;

@Controller
@RequestMapping("/")
public class ClientController {
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private DanhMucService danhMucService;

	@ModelAttribute("listDanhMuc")
	public List<DanhMuc> listDanhMuc(){
		return danhMucService.getAllDanhMuc();
	}

	@GetMapping("/store")
	public String storePage(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "") String range,@RequestParam(defaultValue = "") String brand,@RequestParam(defaultValue = "") String manufactor,@RequestParam(defaultValue = "") String os,@RequestParam(defaultValue = "") String ram,@RequestParam(defaultValue = "") String pin,Model model) {		
		SearchSanPhamObject obj = new SearchSanPhamObject();
		obj.setBrand(brand);
		obj.setDonGia(range);
		obj.setManufactor(manufactor);
		obj.setOs(os);
		obj.setRam(ram);
		obj.setPin(pin);
		Page<SanPham> list = sanPhamService.getSanPhamByBrand(obj,page,12);
		int totalPage = list.getTotalPages();
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("list",list.getContent());
		model.addAttribute("currentPage",page);
		model.addAttribute("range",range);
		model.addAttribute("brand",brand);
		model.addAttribute("manufactor",manufactor);
		model.addAttribute("os",os);
		model.addAttribute("ram",ram);
		model.addAttribute("pin",pin);
		List<Integer> pagelist = new ArrayList<Integer>();
		
		//Lap ra danh sach cac trang
		if(page==1 || page ==2 || page == 3 || page == 4)
		{
			for(int i = 2; i <=5 && i<=totalPage; i++)
			{
				pagelist.add(i);
			}
		}else if(page == totalPage)
		{
			for(int i = totalPage; i >= totalPage - 3 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}else
		{
			for(int i = page; i <= page + 2 && i<= totalPage; i++)
			{
				pagelist.add(i);
			}
			for(int i = page-1; i >= page - 2 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}
		model.addAttribute("pageList",pagelist);
			
		//Lay cac danh muc va hang san xuat tim thay
		Set<String> hangsx = new HashSet<String>();
		Set<String> pinSet = new HashSet<String>();
		Iterable<SanPham> dum = sanPhamService.getSanPhamByTenDanhMuc(brand);
		for(SanPham sp: dum)
		{
			hangsx.add(sp.getHangSanXuat().getTenHangSanXuat());
			if(brand.equals("Laptop"))
			{
				pinSet.add(sp.getDungLuongPin());
			}
		}
		model.addAttribute("hangsx",hangsx);
		model.addAttribute("pinSet",pinSet);
		return "client/store";
	}


}
