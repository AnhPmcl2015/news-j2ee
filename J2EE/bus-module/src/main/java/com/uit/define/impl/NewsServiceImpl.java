package com.uit.define.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uit.converter.SimpleNewsDtoNewsConverter;
import com.uit.define.INewsDao;
import com.uit.define.INewsService;
import com.uit.dto.SimpleNewsDto;
import com.uit.entity.News;

@Service
public class NewsServiceImpl implements INewsService{
	
	@Autowired INewsDao newsDao;
	
	@Autowired SimpleNewsDtoNewsConverter simpleNewsDtoNewsConverter;

	@Override
	public SimpleNewsDto getPriority2News() {
		News news = this.newsDao.getPriority2News();
		
		SimpleNewsDto dto = new SimpleNewsDto();
		
		if(news != null) {
			this.simpleNewsDtoNewsConverter.convertEntityToDto(news, dto);
		}
		
		return dto;
	}

	@Override
	public List<SimpleNewsDto> getPriority1Newses() {
		
		List<News> news = this.newsDao.getPriority1Newses();
		
		return this.convertNewsesToSimpleNewsDtos(news);
	}

	@Override
	public List<SimpleNewsDto> getTrendingNewses() {
		
		List<News> news = this.newsDao.getTrendingNewses();
		
		return this.convertNewsesToSimpleNewsDtos(news);
	}

	@Override
	public List<SimpleNewsDto> getNewestNewses() {
		
		List<News> newses = this.newsDao.getNewestNewses();
		
		return this.convertNewsesToSimpleNewsDtos(newses);
	}

	@Override
	public List<SimpleNewsDto> getMostViewsNewses() {
		
		List<News> newses = this.newsDao.getMostViewsNewses();
		
		return this.convertNewsesToSimpleNewsDtos(newses);
	}
	
	@Override
	public List<SimpleNewsDto> convertNewsesToSimpleNewsDtos(List<News> newses){
		List<SimpleNewsDto> results = new ArrayList<>();
		
		newses.forEach(e->{
			SimpleNewsDto dto = new SimpleNewsDto();
			
			this.simpleNewsDtoNewsConverter.convertEntityToDto(e, dto);
			
			results.add(dto);
		});
		
		Collections.sort(results, (o1, o2) -> o1.getId().compareTo(o2.getId()));
		
		return results;
	}

	@Override
	public void insertOrUpdate(News t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(News t) {
		// TODO Auto-generated method stub
		
	}


}
