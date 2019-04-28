package com.uit.define.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.uit.entity.Approle;
import com.uit.entity.Appuser;
import com.uit.entity.UserRole;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired 
	private AppUserDaoImpl appUserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Appuser appUser = appUserDao.findAppUserByUsername(username);
		
		if(appUser == null) {
			System.out.println("User not found! " + username);
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		
		Set<UserRole> userRoles = appUser.getUserRoles();
		
		Set<Approle> appRoles = userRoles.stream().map(UserRole::getApprole).collect(Collectors.toSet());
		
		Set<String> roleNames = appRoles.stream().map(Approle::getRoleName).collect(Collectors.toSet());
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		if(roleNames != null) {
			roleNames.forEach(name->{
				GrantedAuthority authority = new SimpleGrantedAuthority(name);
				grantList.add(authority);
			});
		}
		
		UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), appUser.getUserPassword(), grantList);
		
		return userDetails;
	}

}
