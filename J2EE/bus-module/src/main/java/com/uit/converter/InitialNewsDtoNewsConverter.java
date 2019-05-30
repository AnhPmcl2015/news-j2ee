package com.uit.converter;

import org.springframework.stereotype.Component;

import com.uit.common.base.IDtoToEntity;
import com.uit.dto.InitialNewsDto;
import com.uit.entity.News;

@Component
public class InitialNewsDtoNewsConverter implements IDtoToEntity<News, InitialNewsDto>{

	@Override
	public void convertDtosToEntity(News entity, InitialNewsDto dto) {
		if(entity == null || dto == null) {
			return;
		}
		
		entity.setNewsId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setSummary(dto.getDescription());
		entity.setThumpnail(dto.getThumpnail());
		entity.setContent(dto.getContent().replace("data-src", "src"));
	}


}
