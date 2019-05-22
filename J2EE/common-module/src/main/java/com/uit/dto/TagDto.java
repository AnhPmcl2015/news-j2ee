package com.uit.dto;

import com.uit.common.base.BaseDto;

public class TagDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -929870269027664980L;

	private String tagName;
	private String url;

	public TagDto(String tagName, String url) {
		super();
		this.tagName = tagName;
		this.url = url;
	}

	public TagDto() {
		super();
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
