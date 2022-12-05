package com.laptopshop.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class HangSanXuat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	private String tenHangSanXuat;


	@OneToMany(mappedBy = "hangSanXuat")
	private List<SanPham> listSanPham;

	public String getTenHangSanXuat() {
		return tenHangSanXuat;
	}

	public void setTenHangSanXuat(String tenHangSanXuat) {
		this.tenHangSanXuat = tenHangSanXuat;
	}

	public List<SanPham> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(List<SanPham> listSanPham) {
		this.listSanPham = listSanPham;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
