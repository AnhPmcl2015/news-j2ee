package com.uit.define;

import java.io.BufferedReader;
import java.util.List;

import com.uit.dto.InitialNewsDto;

public interface IInitialData {
	void initRole();
	void initTag();
	void initNews(String folderPath);
	void initUser();
	void initPriority();
	int saveToListInitialDataDto(List<InitialNewsDto> lists, BufferedReader br, int index, int tag);
}
