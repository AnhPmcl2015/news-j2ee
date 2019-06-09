package com.uit.define.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uit.converter.TagDtoTagConverter;
import com.uit.define.ITagDao;
import com.uit.define.ITagService;
import com.uit.dto.TagDto;
import com.uit.entity.Tag;

@Service
public class TagServiceImpl implements ITagService{
	
	@Autowired private ITagDao tagDao;
	
	@Autowired private TagDtoTagConverter tagDtoTagConverter;

	@Override
	public void insertOrUpdate(Tag t) {
		this.tagDao.insertOrUpdate(t);
	}

	@Override
	public void delete(Tag t) {
		this.tagDao.delete(t);
	}

	@Override
	public List<TagDto> findAllTagDto() {
		List<Tag> tags = this.tagDao.findAll();
		List<TagDto> results = new ArrayList<>();
		
		tags.forEach(tag->{
			TagDto dto = new TagDto();
			this.tagDtoTagConverter.convertEntityToDto(tag, dto);
			
			results.add(dto);
			
		});
		
		
		Collections.sort(results, (o1, o2) -> o1.getTagName().compareTo(o2.getTagName()));
		
		return results;
	}

	@Override
	public long count() {
		return this.tagDao.count();
	}

}
