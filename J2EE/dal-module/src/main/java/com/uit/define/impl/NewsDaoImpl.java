package com.uit.define.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uit.constants.Constants;
import com.uit.define.INewsDao;
import com.uit.entity.News;
import com.uit.repository.NewsRepository;

@Repository
public class NewsDaoImpl implements INewsDao{


	@Autowired private NewsRepository newsRepository;
	
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
		List<News> news = this.newsRepository.findAllByIsDeletedFalseAndIsTrendingFalseAndPriorityIdOrderByNewsIdDesc(Constants.LOWEST_PRIORITY);
		
		return news.size() <= 10 ? news : news.subList(0, 10);
	}

	@Override
	public List<News> getMostViewsNewses() {
		List<News> news = this.newsRepository.findAllByIsTrendingFalseAndIsDeletedFalseAndPriorityIdOrderByViewsDesc(Constants.LOWEST_PRIORITY);
		return news.size() <= 5 ? news : news.subList(0, 5);
	}

}
