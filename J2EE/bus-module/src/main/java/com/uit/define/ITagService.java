package com.uit.define;

import java.util.List;

import com.uit.common.base.IBaseBus;
import com.uit.dto.TagDto;
import com.uit.entity.Tag;

public interface ITagService extends IBaseBus<Tag>{
	List<TagDto> findAllTagDto();
	long count();	
}
