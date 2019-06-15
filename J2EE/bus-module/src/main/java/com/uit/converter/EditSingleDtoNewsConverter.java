package com.uit.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uit.common.base.IDtoToEntity;
import com.uit.define.INewsDao;
import com.uit.dto.CreateSingleDto;
import com.uit.entity.News;

@Component
public class EditSingleDtoNewsConverter implements IDtoToEntity<News, CreateSingleDto> {
	
	@Override
	public void convertDtosToEntity(News entity, CreateSingleDto dto) {
				
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		DateTimeFormatter inputFormatter =DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy");
		LocalDateTime   editDate = LocalDate.parse(dto.getEditDate(), inputFormatter).atStartOfDay();
		entity.setEditDate(editDate);
		entity.setSummary(dto.getDescription());
		entity.setIsDeleted(false);
	}

}
