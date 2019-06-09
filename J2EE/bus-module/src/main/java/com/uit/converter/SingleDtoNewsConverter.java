package com.uit.converter;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.uit.common.base.IEntityToDto;
import com.uit.dto.SingleDto;
import com.uit.entity.News;

@Component
public class SingleDtoNewsConverter implements IEntityToDto<News, SingleDto>{

	@Override
	public void convertEntityToDto(News entity, SingleDto dto) {
		if(entity == null || dto == null) return;
		
		dto.setId(entity.getNewsId());
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setEditDate(entity.getEditDate().format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy")));
		dto.setThumpnail(entity.getThumpnail());
	}

}
