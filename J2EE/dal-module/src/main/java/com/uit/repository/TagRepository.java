package com.uit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uit.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{
	Optional<Tag> findByUrl(String url);
}
