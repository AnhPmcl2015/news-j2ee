package com.uit.define;

import com.uit.common.base.IBaseDao;
import com.uit.entity.Tag;

public interface ITagDao extends IBaseDao<Tag>{
	public Tag getTagByUrl(String url);
}
