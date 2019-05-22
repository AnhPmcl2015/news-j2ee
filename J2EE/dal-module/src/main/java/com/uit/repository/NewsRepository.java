package com.uit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uit.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, String>{
	List<News> findByPriorityIdAndIsDeletedFalseOrderByNewsIdDesc(int priorityId);
	List<News> findByIsTrendingTrueAndIsDeletedFalse();
	List<News> findAllByIsDeletedFalseAndIsTrendingFalseAndPriorityIdOrderByNewsIdDesc(int priorityId);
	List<News> findAllByIsTrendingFalseAndIsDeletedFalseAndPriorityIdOrderByViewsDesc(int priorityId);
}
