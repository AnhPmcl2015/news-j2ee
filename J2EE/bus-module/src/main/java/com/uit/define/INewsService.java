package com.uit.define;

import java.util.List;

import com.uit.common.base.IBaseBus;
import com.uit.dto.CreateSingleDto;
import com.uit.dto.DashboardDto;
import com.uit.dto.SimpleNewsDto;
import com.uit.dto.SingleDto;
import com.uit.entity.News;

public interface INewsService extends IBaseBus<News>{
	SimpleNewsDto getPriority2News();
	List<SimpleNewsDto> getPriority1Newses();
	List<SimpleNewsDto> getTrendingNewses();
	List<SimpleNewsDto> getNewestNewses();
	List<SimpleNewsDto> getMostViewsNewses();
	List<SimpleNewsDto> convertNewsesToSimpleNewsDtos(List<News> newses);
	List<SimpleNewsDto> getLastestModifiedNewses(int limit);
	List<SimpleNewsDto> getAllNewsesByTag(int limit, int page, String tagUrl);
	long countByTagUrl(String tagUrl);
	List<DashboardDto> getNewsToDashboard(int page);
	
	SingleDto getSingleByNewsId(String newsId);
	SingleDto convertNewsToSingleDto(News news);
	SimpleNewsDto getSimpleNewsById(String newsId);
	
	void editSingle(String newsId, CreateSingleDto dto);
}
