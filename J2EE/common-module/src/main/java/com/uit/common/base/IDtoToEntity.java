package com.uit.common.base;

public interface IDtoToEntity<E,D> {
	void convertDtosToEntity(E entity, @SuppressWarnings("unchecked") D...dtos);
}
