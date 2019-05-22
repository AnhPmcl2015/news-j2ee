package com.uit.converter;

import org.springframework.stereotype.Component;

import com.uit.common.base.IEntityToDto;
import com.uit.dto.TagDto;
import com.uit.entity.Tag;

@Component
public class TagDtoTagConverter implements IEntityToDto<Tag, TagDto>{

	@Override
	public void convertEntityToDto(Tag entity, TagDto dto) {
		if(entity == null || dto == null) {
			return;
		}
		
		dto.setTagName(entity.getTagName());
		dto.setUrl(entity.getUrl());
	}

}
