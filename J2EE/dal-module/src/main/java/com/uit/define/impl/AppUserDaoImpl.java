package com.uit.define.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uit.define.IAppUserDao;
import com.uit.entity.AppUser;
import com.uit.repository.AppUserRepository;

@Repository
public class AppUserDaoImpl implements IAppUserDao{

	@Autowired
	private AppUserRepository repository;
	
	@Override
	public AppUser findAppUserByUsername(String username) {
		Optional<AppUser> optAppUser = this.repository.findByUsername(username);
		
		if(optAppUser.isPresent()) {
			return optAppUser.get();
		}
		
		return null;
	}

}
