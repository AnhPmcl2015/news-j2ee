package com.uit.define.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.uit.constants.Constants;
import com.uit.define.INewsDao;
import com.uit.entity.News;
import com.uit.entity.Tag;
import com.uit.repository.NewsPagingRepository;
import com.uit.repository.NewsRepository;
import com.uit.repository.TagRepository;

@Repository
public class NewsDaoImpl implements INewsDao{


	@Autowired private NewsRepository newsRepository;
	@Autowired private NewsPagingRepository newsPagingReposity;
	@Autowired private TagRepository tagRepository;
	
	@Override
	public News findById(String id) {
		Optional<News> newsOpt = this.newsRepository.findById(id);
		
		if(newsOpt.isPresent()) {
			return newsOpt.get();
		}
		return null;
	}

	@Override
	public void insertOrUpdate(News news) {
		this.newsRepository.saveAndFlush(news);
	}

	@Override
	public void delete(News news) {
		this.newsRepository.delete(news);
	}

	@Override
	public News findById(Integer id) {
		return null;
	}

	@Override
	public long count() {
		return this.newsRepository.count();
	}

	@Override
	public List<News> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News getPriority2News() {
		List<News> news = this.newsRepository.findByPriorityIdAndIsDeletedFalseOrderByNewsIdDesc(Constants.HIGHEST_PRIORITY);
		
		if(!news.isEmpty()) {
			return news.get(0);
		}
		
		return null;
	}

	@Override
	public List<News> getPriority1Newses() {
		
		List<News> news = this.newsRepository.findByPriorityIdAndIsDeletedFalseOrderByNewsIdDesc(Constants.MEDIUM_PRIORITY);
		
		return news.size() <= 4 ? news : news.subList(0, 4);

	}

	@Override
	public List<News> getTrendingNewses() {
		
		List<News> news = this.newsRepository.findByIsTrendingTrueAndIsDeletedFalse();
		return news;
	}

	@Override
	public List<News> getNewestNewses() {
		List<News> news = this.newsRepository.findNewestNews(15);
		
		return news;
	}

	@Override
	public List<News> getMostViewsNewses() {
		List<News> news = this.newsRepository.findMostViewsNewses(12);
		return news;
	}

	@Override
	public List<News> getLastestModifiedNewses() {
		return this.newsRepository.findLatestModifiedNewses(9);
	}

	@Override
	public List<News> getAllNewsByTag(int limit, int page, String urlTag) {
		
//		return this.newsRepository.findAllNewsByTag(limit, page, urlTag);
		Optional<Tag> tagOpt = this.tagRepository.findByUrl(urlTag);
		
		Tag tag = null;
		
		if(tagOpt.isPresent()) {
			tag = tagOpt.get();
		}
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by("newsId").ascending());
		Set<Tag> tags = new HashSet<>();
		tags.add(tag);
		
		return this.newsPagingReposity.findAllByTags(tags, pageable);
		
	}
	
	@Override
	public List<News> getAllNewByPage(int page){
		Pageable pageable = PageRequest.of(page, 20, Sort.by("editDate").descending());		
		return this.newsPagingReposity.findAllByIsDeletedFalse(pageable).getContent();
	}
	
	@Override
	public void deleteNewsById(String id) {
		this.newsRepository.deleteNewsById(id);
	}
	
	@Override
	public void editTrendingById(String id) {
		News news = this.newsRepository.findById(id).get();
		boolean isTrending = news.getIsTrending();
		
		if (isTrending)
			news.setIsTrending(false);
		else
			news.setIsTrending(true);
		
		this.insertOrUpdate(news);
	}
	
	@Override
	public void editHighestPriority(String id) {
		News news = this.newsRepository.findById(id).get();
 
		News currentHighestPriorityNews = this.newsRepository.findHighestPriorityNews();
		
		currentHighestPriorityNews.setPriorityId(0);
		news.setPriorityId(2);
		this.insertOrUpdate(currentHighestPriorityNews);
		this.insertOrUpdate(news);
	}
	
	@Override
	public void editPriority(String id, String priority) {
		News news = this.newsRepository.findById(id).get();
		news.setPriorityId(Integer.parseInt(priority));
		this.insertOrUpdate(news);
	}
}
