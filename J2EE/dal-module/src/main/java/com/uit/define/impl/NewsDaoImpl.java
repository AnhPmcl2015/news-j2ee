package com.uit.define.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
