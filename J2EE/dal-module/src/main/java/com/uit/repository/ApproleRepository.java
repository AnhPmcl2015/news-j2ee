package com.uit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uit.entity.Approle;

@Repository
public interface ApproleRepository extends JpaRepository<Approle, Integer>{

}
