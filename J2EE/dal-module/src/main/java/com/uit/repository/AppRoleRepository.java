package com.uit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uit.entity.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer>{
	Optional<AppRole> findByRoleName(String roleName);
}
