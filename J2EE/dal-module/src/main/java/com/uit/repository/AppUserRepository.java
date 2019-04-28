package com.uit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uit.entity.Appuser;

@Repository
public interface AppUserRepository extends JpaRepository<Appuser, Integer>{
	Optional<Appuser> findByUserName(String userName);
}
