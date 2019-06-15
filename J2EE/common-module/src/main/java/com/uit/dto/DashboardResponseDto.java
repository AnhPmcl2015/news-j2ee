package com.uit.dto;

import com.uit.common.base.BaseDto;

public class DashboardResponseDto extends BaseDto{
	
	private String strHandle;

	public String getStrHandle() {
		return strHandle;
	}

	public void setStrHandle(String strHandle) {
		this.strHandle = strHandle;
	}

	public DashboardResponseDto(String strHandle) {
		super();
		this.strHandle = strHandle;
	}

	public DashboardResponseDto() {
		super();
	}
	
	
}
