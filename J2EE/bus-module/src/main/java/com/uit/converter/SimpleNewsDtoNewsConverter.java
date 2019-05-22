package com.uit.converter;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.uit.common.base.IEntityToDto;
import com.uit.dto.SimpleNewsDto;
import com.uit.entity.News;
import com.uit.utils.WebUtils;

@Component
public class SimpleNewsDtoNewsConverter implements IEntityToDto<News, SimpleNewsDto>{

	@Override
	public void convertEntityToDto(News entity, SimpleNewsDto dto) {
		if(entity == null || dto == null) return;
		
		dto.setId(entity.getNewsId());
		dto.setEditDate(entity.getEditDate().format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy")));
		dto.setThumpnail(entity.getThumpnail());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getSummary());
		dto.setUrl(WebUtils.convertTitleToUrl(entity.getTitle()).replaceAll(" ", "-"));
		dto.setTag_url("");
		dto.setErrorMessage("");
	}

}
