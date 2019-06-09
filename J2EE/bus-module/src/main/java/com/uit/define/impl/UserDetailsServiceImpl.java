package com.uit.define.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uit.entity.AppRole;
import com.uit.entity.AppUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired 
	private AppUserDaoImpl appUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserDao.findAppUserByUsername(username);
		
		if(appUser == null) {
			System.out.println("User not found! " + username);
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		
		AppRole appRole = appUser.getAppRole();
		
		String roleName = appRole.getRoleName();
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
		grantList.add(authority);
		
		UserDetails userDetails = (UserDetails) new User(appUser.getUsername(), appUser.getUserPassword(), grantList);
		
		return userDetails;
	}

}
