package com.uit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uit.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News, String>{
	List<News> findByPriorityIdAndIsDeletedFalseOrderByNewsIdDesc(int priorityId);
	List<News> findByIsTrendingTrueAndIsDeletedFalse();
	List<News> findAllByIsDeletedFalseAndIsTrendingFalseAndPriorityIdOrderByNewsIdDesc(int priorityId);
	List<News> findAllByIsTrendingFalseAndIsDeletedFalseAndPriorityIdOrderByViewsDesc(int priorityId);
	
	@Query(value = "select * from news where priority_id = 0 and is_trending = 0 and is_deleted = 0 order by news_id desc limit :limit", nativeQuery = true)
	List<News> findNewestNews(@Param("limit") int limit);
	
	@Query(value = "select * from news where priority_id = 0 and is_trending = 0 and is_deleted = 0 order by views desc limit :limit", nativeQuery = true)
	List<News> findMostViewsNewses(@Param("limit") int limit);
	
	@Query(value = "select * from news where priority_id = 0 and is_trending = 0 and is_deleted = 0 order by edit_date desc limit :limit", nativeQuery = true)
	List<News> findLatestModifiedNewses(@Param("limit") int limit);
	
	@Query(value = "select a.* from news as a left join tag_news as b on a.news_id = b.news_id\r\n" + 
			"left join tag as c on b.tag_id = c.tag_id where c.url = :tagUrl order by a.news_id limit :limit offset :offSet", nativeQuery = true)
	List<News> findAllNewsByTag(@Param("limit") int limit, @Param("offSet") int offSet, @Param("tagUrl") String tagUrl);
}
