package com.uit.common.base;

public interface IEntityToDto<E, D> {
	void convertEntityToDto(E entity, D dto);
}
