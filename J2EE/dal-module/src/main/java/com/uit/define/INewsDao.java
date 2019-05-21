package com.uit.define;

import com.uit.common.base.IBaseDao;
import com.uit.entity.News;

public interface INewsDao extends IBaseDao<News> {
	News findById(String id);
}
