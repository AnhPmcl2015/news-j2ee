package com.uit.converter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uit.common.base.IDtoToEntity;
import com.uit.common.base.IEntityToDto;
import com.uit.define.IAppUserDao;
import com.uit.define.impl.AppUserDaoImpl;
import com.uit.define.impl.NewsDaoImpl;
import com.uit.dto.CreateSingleDto;
import com.uit.dto.SingleDto;
import com.uit.entity.AppUser;
import com.uit.entity.News;

@Component
public class CreateSingleDtoNewsConverter implements IDtoToEntity<News, CreateSingleDto> {

	@Autowired IAppUserDao userDao;
	
	@Override
	public void convertDtosToEntity(News entity, CreateSingleDto dto) {
		if (entity == null || dto == null) return;
		
		//entity.setNewsId(newsId);
		entity.setTitle(dto.getTitle());
		AppUserDaoImpl dao = new AppUserDaoImpl();
		
		AppUser appUser = dao.findById(1);
		
		entity.setAppUserByAuthorId(appUser);
		entity.setAppUserByAcceptanceUserId(appUser);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime editDate = LocalDateTime.parse(dto.getEditDate(), formatter);
		entity.setEditDate(editDate);
		
		entity.setIsDeleted(false);
		entity.setIsTrending(false);
		entity.setSummary(dto.getDescription());
		
		if (dto.getThumpnail() == null || dto.getThumpnail().isEmpty())
			entity.setThumpnail("http://localhost:8080/img/default-img.jpg");
		else {
			String thumpnailLink = dto.getThumpnail();
			String[] link = thumpnailLink.split("\"");
			entity.setThumpnail(link[1]);
		}

		entity.setContent(dto.getContent());
	}
}