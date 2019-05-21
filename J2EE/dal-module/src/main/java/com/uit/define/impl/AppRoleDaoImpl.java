package com.uit.define.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uit.define.IAppRoleDao;
import com.uit.entity.AppRole;
import com.uit.repository.AppRoleRepository;

@Repository
public class AppRoleDaoImpl implements IAppRoleDao{

	
	@Autowired private AppRoleRepository appRoleRepository;
	
	@Override
	public AppRole findByRoleName(String roleName) {
		
		Optional<AppRole> appRoleOpt = this.appRoleRepository.findByRoleName(roleName);
		
		if(appRoleOpt.isPresent()) {
			return appRoleOpt.get();
		}
		return null;
	}

	@Override
	public AppRole findById(Integer id) {
		
		Optional<AppRole> appRoleOpt = this.appRoleRepository.findById(id);
		
		if(appRoleOpt.isPresent()) {
			return appRoleOpt.get();
		}
		return null;
	}

	@Override
	public void insertOrUpdate(AppRole entity) {
		this.appRoleRepository.saveAndFlush(entity);
	}

	@Override
	public void delete(AppRole entity) {
		this.appRoleRepository.delete(entity);
	}

	@Override
	public long count() {
		return this.appRoleRepository.count();
	}

}
