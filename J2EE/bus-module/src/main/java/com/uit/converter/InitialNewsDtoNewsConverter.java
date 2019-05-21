package com.uit.converter;

import org.springframework.stereotype.Component;

import com.uit.common.base.IDtoToEntity;
import com.uit.dto.InitialNewsDto;
import com.uit.entity.News;

@Component
public class InitialNewsDtoNewsConverter implements IDtoToEntity<News, InitialNewsDto>{

	@Override
	public void convertDtosToEntity(News entity, InitialNewsDto... dtos) {
		if(entity == null || dtos.length < 0) {
			return;
		}
		
		entity.setNewsId(dtos[0].getId());
		entity.setTitle(dtos[0].getTitle());
		entity.setSummary(dtos[0].getDescription());
		entity.setThumpnail(dtos[0].getThumpnail());
		entity.setContent(dtos[0].getContent());
	}


}
