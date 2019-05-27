package com.uit.dto;

import com.uit.common.base.BaseDto;

public class PaginationDto extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4575399678825409351L;

	private String index;

	public PaginationDto(String index) {
		super();
		this.index = index;
	}

	public PaginationDto() {
		super();
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

}
