package com.laptopshop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DanhMuc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	private String tenDanhMuc;

	@JsonIgnore
	@OneToMany(mappedBy = "danhMuc")
	private List<SanPham> listSanPham;

	public DanhMuc() {
	}

	public DanhMuc(long id, String tenDanhMuc, List<SanPham> listSanPham) {
		this.id = id;
		this.tenDanhMuc = tenDanhMuc;
		this.listSanPham = listSanPham;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public List<SanPham> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(List<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}
}
