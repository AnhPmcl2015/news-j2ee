package com.uit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uit.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

}
