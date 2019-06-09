package com.uit.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.uit.entity.News;
import com.uit.entity.Tag;

@Repository
public interface NewsPagingRepository extends PagingAndSortingRepository<News, String>{
	List<News> findAllByTags(Set<Tag> tags, Pageable pageable);
}
