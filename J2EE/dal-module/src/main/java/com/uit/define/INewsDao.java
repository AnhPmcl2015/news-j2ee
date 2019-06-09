package com.uit.define;

import java.util.List;

import com.uit.common.base.IBaseDao;
import com.uit.entity.News;

public interface INewsDao extends IBaseDao<News> {
	News findById(String id);
	News getPriority2News();
	List<News> getPriority1Newses();
	List<News> getTrendingNewses();
	List<News> getNewestNewses();
	List<News> getMostViewsNewses();
	List<News> getLastestModifiedNewses();
	List<News> getAllNewsByTag(int limit, int page, String urlTag);
}
