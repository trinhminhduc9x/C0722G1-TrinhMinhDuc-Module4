package com.laptopshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String tenSanPham;
	private long donGia;
	private int donViKho;
	private int donViBan;
	private String thongTinBaoHanh;
	private String thongTinChung;
	private String manHinh;
	private String heDieuHanh;
	private String cpu;
	private String ram;
	private String thietKe;
	private String dungLuongPin;
	
	@Transient
	@JsonIgnore
	private MultipartFile hinhAnh;

	@ManyToOne
	@JoinColumn(name = "ma_danh_muc")
	private DanhMuc danhMuc;

	@ManyToOne
	@JoinColumn(name = "ma_hang_sx")
	private HangSanXuat hangSanXuat;

	public SanPham() {
	}

	public SanPham(Long id, String tenSanPham, long donGia, int donViKho, int donViBan,
				   String thongTinBaoHanh, String thongTinChung, String manHinh, String heDieuHanh,
				   String cpu, String ram, String thietKe, String dungLuongPin,
				   MultipartFile hinhAnh, DanhMuc danhMuc, HangSanXuat hangSanXuat) {
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.donViKho = donViKho;
		this.donViBan = donViBan;
		this.thongTinBaoHanh = thongTinBaoHanh;
		this.thongTinChung = thongTinChung;
		this.manHinh = manHinh;
		this.heDieuHanh = heDieuHanh;
		this.cpu = cpu;
		this.ram = ram;
		this.thietKe = thietKe;
		this.dungLuongPin = dungLuongPin;
		this.hinhAnh = hinhAnh;
		this.danhMuc = danhMuc;
		this.hangSanXuat = hangSanXuat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public long getDonGia() {
		return donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}

	public int getDonViKho() {
		return donViKho;
	}

	public void setDonViKho(int donViKho) {
		this.donViKho = donViKho;
	}

	public int getDonViBan() {
		return donViBan;
	}

	public void setDonViBan(int donViBan) {
		this.donViBan = donViBan;
	}

	public String getThongTinBaoHanh() {
		return thongTinBaoHanh;
	}

	public void setThongTinBaoHanh(String thongTinBaoHanh) {
		this.thongTinBaoHanh = thongTinBaoHanh;
	}

	public String getThongTinChung() {
		return thongTinChung;
	}

	public void setThongTinChung(String thongTinChung) {
		this.thongTinChung = thongTinChung;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getThietKe() {
		return thietKe;
	}

	public void setThietKe(String thietKe) {
		this.thietKe = thietKe;
	}

	public String getDungLuongPin() {
		return dungLuongPin;
	}

	public void setDungLuongPin(String dungLuongPin) {
		this.dungLuongPin = dungLuongPin;
	}

	public MultipartFile getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(MultipartFile hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
}
