package com.laptopshop.service.impl;


import org.springframework.stereotype.Service;

import com.laptopshop.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Override
	public String findLoggedInUsername() {
		return null;
	}

	@Override
	public void autologin(String email, String password) {

	}
}
