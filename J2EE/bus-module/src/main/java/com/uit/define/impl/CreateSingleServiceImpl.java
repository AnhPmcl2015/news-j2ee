package com.uit.define.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uit.constants.Constants;
import com.uit.converter.CreateSingleDtoNewsConverter;
import com.uit.define.ICreateSingleService;
import com.uit.dto.CreateSingleDto;
import com.uit.entity.News;
import com.uit.entity.Tag;

@Service
public class CreateSingleServiceImpl implements ICreateSingleService{
	
	@Autowired private CreateSingleDtoNewsConverter converter;
	@Autowired private AppUserDaoImpl appUserDao;
	@Autowired private NewsDaoImpl newsDao;
	@Autowired private TagDaoImpl tagDao;
	
	public void CreateSingle(CreateSingleDto dto) {
		News news = new News();
		
		this.converter.convertDtosToEntity(news, dto);
		
		news.setAppUserByAuthorId(appUserDao.findAppUserByUsername("anh-pt"));
		news.setAppUserByAcceptanceUserId(appUserDao.findAppUserByUsername("anh-pt"));
		
//		//not working yet
//		Set<Tag> tagSet = new HashSet<>();
//		tagSet.add(tagDao.getTagByUrl(dto.getTag()));
//		news.setTags(tagSet);
//		//not working yet
		
		Tag tag = this.tagDao.getTagByUrl(dto.getTag());
		
		Set<Tag> tags = new HashSet<>();
		tags.add(tag);
		news.setTags(tags);
		
		news.setNewsId(Constants.defaultNewsId + String.valueOf(newsDao.count() + 1));

		newsDao.insertOrUpdate(news);
	}
}
