package com.uit.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uit.define.IDashboardService;

@Service
public class DashboardServiceImpl implements IDashboardService{
	
	@Autowired private NewsDaoImpl newsDao;
	
	@Override
	public void handleDelete(String newsId) {
		newsDao.deleteNewsById(newsId);
	}
	
	@Override
	public void handleEditTrending(String newsId) {
		newsDao.editTrendingById(newsId);
	}
	
	@Override
	public void handleEditPriority(String newsId, String priority) {
		if (Integer.valueOf(priority) == 2) {
			newsDao.editHighestPriority(newsId);
		}
		else {
			newsDao.editPriority(newsId, priority);
		}
	}
}
