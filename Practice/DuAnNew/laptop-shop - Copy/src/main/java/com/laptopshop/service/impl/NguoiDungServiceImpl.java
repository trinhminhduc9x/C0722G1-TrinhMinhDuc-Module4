package com.laptopshop.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.laptopshop.model.NguoiDung;
import com.laptopshop.model.VaiTro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.laptopshop.dto.TaiKhoanDTO;

import com.laptopshop.repository.NguoiDungRepository;
import com.laptopshop.repository.VaiTroRepository;
import com.laptopshop.service.NguoiDungService;

@Service
@Transactional
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository nguoiDungRepo;

	@Autowired
	private VaiTroRepository vaiTroRepo;


	@Override
	public NguoiDung findByEmail(String email) {
		return nguoiDungRepo.findByEmail(email);
	}

	@Override
	public NguoiDung findByConfirmationToken(String confirmationToken) {
		return null;
	}

	@Override
	public NguoiDung saveUserForMember(NguoiDung nd) {
		return null;
	}


	@Override
	public NguoiDung findById(long id) {
		NguoiDung nd = nguoiDungRepo.findById(id).get();
		return nd;
	}

	@Override
	public NguoiDung updateUser(NguoiDung nd) {
		return nguoiDungRepo.save(nd);
	}

	@Override
	public void changePass(NguoiDung nd, String newPass) {

	}

	@Override
	public Page<NguoiDung> getNguoiDungByVaiTro(Set<VaiTro> vaiTro, int page) {
		return null;
	}

	@Override
	public List<NguoiDung> getNguoiDungByVaiTro(Set<VaiTro> vaiTro) {
		return null;
	}

	@Override
	public NguoiDung saveUserForAdmin(TaiKhoanDTO dto) {
		return null;
	}


	@Override
	public void deleteById(long id) {
		nguoiDungRepo.deleteById(id);
	}

}
