package com.uit.define.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

	@Override
	public void insertOrUpdate(AppUser appUser) {
		this.repository.saveAndFlush(appUser);
	}

	@Override
	public void delete(AppUser appUser) {
		this.repository.delete(appUser);
	}

	@Override
	public AppUser findById(Integer id) {
		Optional<AppUser> appUserOpt = this.repository.findById(id);
		
		if(appUserOpt.isPresent()) {
			return appUserOpt.get();
		}
		return null;
	}

	@Override
	public long count() {
		return this.repository.count();
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
