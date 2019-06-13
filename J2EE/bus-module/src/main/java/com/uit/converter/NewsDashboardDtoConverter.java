package com.uit.converter;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.uit.common.base.IEntityToDto;
import com.uit.dto.DashboardDto;
import com.uit.entity.News;

@Component
public class NewsDashboardDtoConverter implements IEntityToDto<News, DashboardDto> {

	@Override
	public void convertEntityToDto(News entity, DashboardDto dto) {
		if (entity == null || dto == null) return;
		
		dto.setId(entity.getNewsId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getSummary());
		dto.setAuthor(entity.getAppUserByAuthorId().getFullname());
		dto.setAccepted(entity.getAppUserByAcceptanceUserId().getFullname());
		dto.setPriority(String.valueOf(entity.getPriorityId()));
		
		if (entity.getIsTrending())
			dto.setIsTrending(true);
		else 
			dto.setIsTrending(false);
		dto.setViews(String.valueOf(entity.getViews()));
		dto.setEditDate(entity.getEditDate().format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy")));
		dto.setLink("hello world");
	}
	
}
