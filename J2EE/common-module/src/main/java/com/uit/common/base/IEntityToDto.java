package com.uit.common.base;

public interface IEntityToDto<E, D> {
	@SuppressWarnings("unchecked")
	void convertEntityToDto(E entity, D...dtos);
}
