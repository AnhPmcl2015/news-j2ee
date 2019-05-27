package com.uit.define.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uit.converter.SimpleNewsDtoNewsConverter;
import com.uit.converter.SingleDtoNewsConverter;
import com.uit.define.INewsDao;
import com.uit.define.INewsService;
import com.uit.define.ITagDao;
import com.uit.dto.SimpleNewsDto;
import com.uit.dto.SingleDto;
import com.uit.entity.AppUser;
import com.uit.entity.News;
import com.uit.entity.Tag;

@Service
public class NewsServiceImpl implements INewsService{
	
	@Autowired INewsDao newsDao;
	
	@Autowired ITagDao tagDao;
	
	@Autowired SimpleNewsDtoNewsConverter simpleNewsDtoNewsConverter;
	
	@Autowired SingleDtoNewsConverter singleDtoNewsConverter;

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

	@Override
	public List<SimpleNewsDto> getLastestModifiedNewses(int limit) {
		List<News> newses = this.newsDao.getLastestModifiedNewses();
		return this.convertNewsesToSimpleNewsDtos(newses);
	}

	@Override
	public List<SimpleNewsDto> getAllNewsesByTag(int limit, int page, String tagUrl) {
		List<News> newses = this.newsDao.getAllNewsByTag(limit, (page-1) * limit + 1, tagUrl);
		return this.convertNewsesToSimpleNewsDtos(newses);
	}

	@Override
	public long countByTagUrl(String tagUrl) {
		Tag tag = this.tagDao.getTagByUrl(tagUrl);
		
		Set<News> newes = tag.getNewses();
		return newes.size();
	}

	@Override
	public SingleDto getSingleByNewsId(String newsId) {
		News news = this.newsDao.findById(newsId);
		return convertNewsToSingleDto(news);
	}

	@Override
	public SingleDto convertNewsToSingleDto(News news) {
		SingleDto dto = new SingleDto();
		
		this.singleDtoNewsConverter.convertEntityToDto(news, dto);
		
		AppUser appUser = news.getAppUserByAuthorId();
		dto.setAuthor(appUser.getFullname());
		
		return dto;
	}
}
