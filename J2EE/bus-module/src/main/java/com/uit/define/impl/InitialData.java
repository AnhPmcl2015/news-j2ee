package com.uit.define.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uit.constants.Constants;
import com.uit.converter.InitialNewsDtoNewsConverter;
import com.uit.define.IAppRoleDao;
import com.uit.define.IAppUserDao;
import com.uit.define.IInitialData;
import com.uit.define.INewsDao;
import com.uit.define.IPriorityDao;
import com.uit.define.ITagDao;
import com.uit.dto.InitialNewsDto;
import com.uit.entity.AppRole;
import com.uit.entity.AppUser;
import com.uit.entity.News;
import com.uit.entity.Priority;
import com.uit.entity.Tag;
import com.uit.utils.EncrytedPasswordUtils;


@Service
public class InitialData implements IInitialData {

	private static final Logger logger = LoggerFactory.getLogger(InitialData.class);

	@Autowired
	private IAppRoleDao appRoleDaoImpl;
	@Autowired
	private IAppUserDao appUserDaoImpl;
	@Autowired
	private ITagDao tagDaoImpl;
	@Autowired
	private IPriorityDao priorityDaoImpl;
	@Autowired
	private INewsDao newsDaoImpl;
	@Autowired
	private InitialNewsDtoNewsConverter initialNewsDtoNewsConverter;

	@Override
	public void initRole() {

		if (this.appRoleDaoImpl.count() > 0) {
			logger.info("Roles were imported");
			return;
		}

		AppRole role1 = new AppRole(1, "EDITOR");
		AppRole role2 = new AppRole(2, "ROLE_ADMIN");

		appRoleDaoImpl.insertOrUpdate(role1);
		appRoleDaoImpl.insertOrUpdate(role2);
	}

	@Override
	public void initTag() {

		if (this.tagDaoImpl.count() > 0) {
			logger.info("Tags were imported");
			return;
		}

		Tag tag1 = new Tag("Công nghệ", "cong-nghe");
		Tag tag2 = new Tag("Đời sống", "doi-song");
		Tag tag3 = new Tag("Giáo dục", "giao-duc");
		Tag tag4 = new Tag("Giới trẻ", "gioi-tre");
		Tag tag5 = new Tag("Sức khỏe", "suc-khoe");
		Tag tag6 = new Tag("Tài chính kinh doanh", "tai-chinh-kinh-doanh");
		Tag tag7 = new Tag("Thế giới", "the-gioi");
		Tag tag8 = new Tag("Thời sự", "thoi-su");
		Tag tag9 = new Tag("Văn hóa", "van-hoa");

		this.tagDaoImpl.insertOrUpdate(tag1);
		this.tagDaoImpl.insertOrUpdate(tag2);
		this.tagDaoImpl.insertOrUpdate(tag3);
		this.tagDaoImpl.insertOrUpdate(tag4);
		this.tagDaoImpl.insertOrUpdate(tag5);
		this.tagDaoImpl.insertOrUpdate(tag6);
		this.tagDaoImpl.insertOrUpdate(tag7);
		this.tagDaoImpl.insertOrUpdate(tag8);
		this.tagDaoImpl.insertOrUpdate(tag9);
	}

	@Override
	public void initNews(String folderPath) {
		
		if(this.newsDaoImpl.count() > 0) {
			logger.info("Newses were imported");
			return;
		}
		
		int index = 0;
		
		List<InitialNewsDto> list = new ArrayList<>();
		
		File congNghe = new File(folderPath + "190520-thanhnien-cong-nghe.txt");
		File doiSong = new File(folderPath + "190520-thanhnien-doi-song.txt");
		File giaoDuc = new File(folderPath + "190520-thanhnien-giao-duc.txt");
		File gioiTre = new File(folderPath + "190520-thanhnien-gioi-tre.txt");
		File sucKhoe = new File(folderPath + "190520-thanhnien-suc-khoe.txt");
		File taiChinhKinhDoanh = new File(folderPath + "190520-thanhnien-tai-chinh-kinh-doanh.txt");
		File theGioi = new File(folderPath + "190520-thanhnien-the-gioi.txt");
		File thoiSu = new File(folderPath + "190520-thanhnien-thoi-su.txt");
		File vanHoa = new File(folderPath + "190520-thanhnien-van-hoa.txt");

		BufferedReader brCongNghe = null;
		BufferedReader brDoiSong = null;
		BufferedReader brGiaoDuc = null;
		BufferedReader brGioiTre = null;
		BufferedReader brSucKhoe = null;
		BufferedReader brTaiChinhKinhDoanh = null;
		BufferedReader brTheGioi = null;
		BufferedReader brThoiSu = null;
		BufferedReader btVanHoa = null;

		try {
			brCongNghe = new BufferedReader(new InputStreamReader(new FileInputStream(congNghe)));
			brDoiSong = new BufferedReader(new InputStreamReader(new FileInputStream(doiSong)));
			brGiaoDuc = new BufferedReader(new InputStreamReader(new FileInputStream(giaoDuc)));
			brGioiTre = new BufferedReader(new InputStreamReader(new FileInputStream(gioiTre)));
			brSucKhoe = new BufferedReader(new InputStreamReader(new FileInputStream(sucKhoe)));
			brTaiChinhKinhDoanh = new BufferedReader(new InputStreamReader(new FileInputStream(taiChinhKinhDoanh)));
			brTheGioi = new BufferedReader(new InputStreamReader(new FileInputStream(theGioi)));
			brThoiSu = new BufferedReader(new InputStreamReader(new FileInputStream(thoiSu)));
			btVanHoa = new BufferedReader(new InputStreamReader(new FileInputStream(vanHoa)));
			
			index = this.saveToListInitialDataDto(list, brCongNghe, index, Constants.CONG_NGHE);
			index = this.saveToListInitialDataDto(list, brDoiSong, index, Constants.DOI_SONG);
			index = this.saveToListInitialDataDto(list, brGiaoDuc, index, Constants.GIAO_DUC);
			index = this.saveToListInitialDataDto(list, brGioiTre, index, Constants.GIOI_TRE);
			index = this.saveToListInitialDataDto(list, brSucKhoe, index, Constants.SUC_KHOE);
			index = this.saveToListInitialDataDto(list, brTaiChinhKinhDoanh, index, Constants.TAI_CHINH_KINH_DOANH);
			index = this.saveToListInitialDataDto(list, btVanHoa, index, Constants.VAN_HOA);
			index = this.saveToListInitialDataDto(list, brTheGioi, index, Constants.THE_GIOI);
			index = this.saveToListInitialDataDto(list, brThoiSu, index, Constants.THOI_SU);

			brCongNghe.close();
			brDoiSong.close();
			brGiaoDuc.close();
			brGioiTre.close();
			brSucKhoe.close();
			brTaiChinhKinhDoanh.close();
			brTheGioi.close();
			brThoiSu.close();
			btVanHoa.close();
			
			this.insertNewsToDb(list);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public int saveToListInitialDataDto(List<InitialNewsDto> list, BufferedReader br, int index, int tag) {
		String line;

		int count = 1;
		String title = "";
		String description = "";
		String thumpnail = "";
		StringBuilder contentBuilder = new StringBuilder();
		
		try {
			while ((line = br.readLine()) != null) {
			
				switch (count) {
				case 1:
					title = line.replace("Title: ", "");
					break;
				case 2:
					description = line.replace("Description: ", "");
					break;
				case 3:
					thumpnail = line.replace("HÌnh ảnh thumpnail: ", "");
					if("".equals(thumpnail.trim())) {
						thumpnail = "http://localhost:8080/img/default-img.jpg";
					}
					break;
				default:
					if(!line.contains("========")) {
						contentBuilder.append(line.replace("Content: ", ""));
					}
					break;
				}
				
				if(line.contains("=======")) {
					count = 0;
					list.add(new InitialNewsDto(String.format(Constants.defaultNewsId + "%03d", index), title, description, thumpnail, tag, contentBuilder.toString()));
					title = "";
					description = "";
					thumpnail = "";
					contentBuilder = new StringBuilder();
					index ++;
				}
				
				count ++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return index;
	}

	private void insertNewsToDb(List<InitialNewsDto> list) {
		AppUser appUser = this.appUserDaoImpl.findAppUserByUsername("anh-pt");
		
		
		
		for(InitialNewsDto dto : list) {
			News news = new News();
			
			this.initialNewsDtoNewsConverter.convertDtosToEntity(news, dto);
			
			news.setAppUserByAuthorId(appUser);
			news.setAppUserByAcceptanceUserId(appUser);
			
			Tag tag = this.tagDaoImpl.findById(dto.getTag());
			
			Set<Tag> tags = new HashSet<>();
			tags.add(tag);
			news.setTags(tags);
			news.setEditDate(LocalDateTime.now());
			
			this.newsDaoImpl.insertOrUpdate(news);
		}
	}
	
	@Override
	public void initUser() {
		if (this.appUserDaoImpl.count() > 0) {
			logger.info("Users were imported");
			return;
		}

		AppRole appRole = this.appRoleDaoImpl.findById(2);

		AppUser appUser1 = new AppUser(appRole, "anh-pt", null, EncrytedPasswordUtils.encrytePassword("123"),
				"Phan Thế Anh", null);
		AppUser appUser2 = new AppUser(appRole, "duong-th", null, EncrytedPasswordUtils.encrytePassword("123"),
				"Trần Hàm Dương", null);
		AppUser appUser3 = new AppUser(appRole, "anh-bnh", null, EncrytedPasswordUtils.encrytePassword("123"),
				"Bùi Nguyễn Hoàng Anh", null);
		AppUser appUser4 = new AppUser(appRole, "vinh-tp", null, EncrytedPasswordUtils.encrytePassword("123"),
				"Trần Phú Vinh", null);

		this.appUserDaoImpl.insertOrUpdate(appUser1);
		this.appUserDaoImpl.insertOrUpdate(appUser2);
		this.appUserDaoImpl.insertOrUpdate(appUser3);
		this.appUserDaoImpl.insertOrUpdate(appUser4);
	}

	@Override
	public void initPriority() {
		if (this.priorityDaoImpl.count() > 0) {
			logger.info("Priorities were imported");
			return;
		}

		Priority priority1 = new Priority(0);
		Priority priority2 = new Priority(1);
		Priority priority3 = new Priority(2);

		this.priorityDaoImpl.insertOrUpdate(priority1);
		this.priorityDaoImpl.insertOrUpdate(priority2);
		this.priorityDaoImpl.insertOrUpdate(priority3);

	}

}
